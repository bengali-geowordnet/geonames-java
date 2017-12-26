package edu.aiub.cs.geonames.controller;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Please visit https://projects.csail.mit.edu/jwi/api/index.html for more information.
 */
@Controller
@RequestMapping(path = "/wn")
public class WNController {

    @RequestMapping(value = "/sense", method = RequestMethod.GET)
    public @ResponseBody
    String getSense() {
        File file = new File("files/dict");
        URL fileUrl = null;
        try {
            fileUrl = file.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(fileUrl == null) {
            return "{status:\"ERROR \"}";
        }
        // construct the dictionary object and open it
        IDictionary dict = new Dictionary(fileUrl);
        try {
            dict.open();
            IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);
            IWordID wordID = idxWord.getWordIDs().get(0);
            IWord word = dict.getWord(wordID);
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\"id\": \"").append(wordID).append("\",");
            sb.append("\"lemma\":").append(word.getLemma()).append("\",");
            sb.append("\"gloss\":").append(word.getSynset().getGloss()).append("\",");
            sb.append("}");
            return sb.toString();
        } catch (IOException e) {
            return "{status:\" "+ e.getMessage() +" \"}";
        }
    }
}
