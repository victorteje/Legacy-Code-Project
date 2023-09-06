package com.example.first.api.services;

import com.example.first.api.models.CLogin;
import com.example.first.api.repositories.ILoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CLoginService {

    @Autowired
    private ILoginRepository myRepo;

    public CLogin tryLogin(CLogin myLogin) {

        CLogin userOK=myRepo.findByUserEmailAndUserPassword(myLogin.getUserEmail(), myLogin.getUserPassword());

        if(userOK!=null){
            return userOK;
        }
        else return null;
    }

    public CLogin addNewUser(CLogin newData) {
        try{
            if(myRepo.findByUserEmail(newData.getUserEmail())==null){
                return myRepo.save(newData);
            }
            else return null;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
    public boolean addFavs(CLogin userData) {
        try{
            if(myRepo.findByUserEmailAndUserPassword(userData.getUserEmail(), userData.getUserPassword())!=null){
                myRepo.save(userData);
                return true;
            }
            else return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
      }
}

}
