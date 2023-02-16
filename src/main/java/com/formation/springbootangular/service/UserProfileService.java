// FEAT-UserProfile


package com.formation.springbootangular.service;

import com.formation.springbootangular.entity.UserProfile;
import com.formation.springbootangular.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository ;

    public UserProfileService(UserProfileRepository userProfileRepository) { this.userProfileRepository = userProfileRepository ;}

    /**
     * create d'un userprofile
     * @param userProfile
     * @return UserProfile
     * @throws Exception
     */
    public UserProfile create(UserProfile userProfile) throws Exception {

        if(userProfileRepository.findUserProfileById(userProfile.getId()) != null)
        {
            throw new Exception("UserProfile Inexistant") ;
        };
        return userProfileRepository.save(userProfile) ;

    }
    /**
     * update d'un userprofile
     * @param userProfile
     * @return UserProfile
     * @throws Exception
     */
    public UserProfile update(UserProfile userProfile) throws Exception {
        userProfileRepository.findById(userProfile.getId()).orElseThrow(() -> new Exception("Le userprofile n'existe pas.")) ;
        return userProfileRepository.save(userProfile) ;
    }
    /**
     * delete d'un userprofile
     * @param id
     * @return true si ok, false si ko
     * @throws Exception
     */
    public boolean delete(Integer id) throws Exception {
        userProfileRepository.findById(id).orElseThrow(Exception::new);
        userProfileRepository.deleteById(id);
        return !userProfileRepository.findById(id).isPresent();
    }

}
