package controller;

import entity.BukuEntity;
import entity.InputBukuEntity;
import entity.StaffEntity;

import java.util.Date;

public class StaffController {
    int indexLogin = 0;

    public StaffController(){
    }

    public void dataStaff(){
        String id [] = {"01","02","03"};
        String nama [] = {"tasya","rory","jio"};
        String password [] = {"01","02","03"};
        String notelp [] = {"01","02","03"};
        String tglLahir [] = {"17/12/2002","01/07/2001","06/06/2000"};

        for (int i=0; i< nama.length; i++){
            ModelController.staffModel.insert(new StaffEntity(id[i], nama[i], password[i], notelp[i], new Date(tglLahir[i])));
        }
    }

    public void login(String nama, String password){
        indexLogin = ModelController.staffModel.cekData(nama, password);
    }

    public StaffEntity staffEntity(){
        return ModelController.staffModel.getStaffEntityArrayList(indexLogin);
    }

    public void updateIsVerified(int index, BukuEntity bukuEntity){
        ModelController.inputBukuModel.UpdateIsVerified(index,new InputBukuEntity(bukuEntity,true));
    }
}
