package edu.aiub.cs.geonames.repository;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 */

import edu.aiub.cs.geonames.model.base.AppInfo;
import edu.aiub.cs.geonames.model.base.Location;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AppInfoRepository extends CrudRepository<AppInfo, Long> {

}