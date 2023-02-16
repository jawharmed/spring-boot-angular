// FEAT-userprofile
package com.formation.springbootangular.repository;

import com.formation.springbootangular.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    UserProfile findUserProfileById(Integer id) ;
}
