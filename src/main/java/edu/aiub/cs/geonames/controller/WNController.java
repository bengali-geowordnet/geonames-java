package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import edu.aiub.cs.geonames.model.wn.Word;
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Please visit https://projects.csail.mit.edu/jwi/api/index.html for more information.
 */
@Controller
@RequestMapping(path = "api/v1/wn")
public class WNController {

    @GetMapping(value = "/pos/{pos}/sense/{concept}")
    String getSense(@PathVariable String pos, @PathVariable String concept) {
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
            IIndexWord idxWord;
            switch (pos) {
                case "noun":
                    idxWord = dict.getIndexWord(concept, POS.NOUN);
                    break;
                case "verb":
                    idxWord = dict.getIndexWord(concept, POS.VERB);
                    break;
                case "adverb":
                    idxWord = dict.getIndexWord(concept, POS.ADVERB);
                    break;
                case "adjective":
                    idxWord = dict.getIndexWord(concept, POS.ADJECTIVE);
                    break;
                default:
                    idxWord = dict.getIndexWord(concept, POS.NOUN);
            }
            if(idxWord==null) {
                return "{status:\" Word according to the POS is not found.\"}";
            }
            List<Word> listOfWords = new ArrayList<>();
            for (IWordID wordID: idxWord.getWordIDs()) {
                IWord word = dict.getWord(wordID);
                Word wnWord = new Word(wordID.toString(),word.getLemma(),word.getSynset().getGloss());
                listOfWords.add(wnWord);
                //System.out.println(word.getSynset().getGloss());
            }
            return new ObjectMapper().writeValueAsString(listOfWords);
        } catch (IOException e) {
            return "{status:\" "+ e.getMessage() +" \"}";
        }
    }
}
