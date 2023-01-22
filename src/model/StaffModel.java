package model;

import entity.StaffEntity;

import java.util.ArrayList;

public class StaffModel implements Model{
    public ArrayList<StaffEntity> staffEntityArrayList;

    public StaffModel(){
        staffEntityArrayList = new ArrayList<StaffEntity>();
    }

    public void insert(StaffEntity staffEntity){
        staffEntityArrayList.add(staffEntity);
    }

    public int cekData(String nama, String password){
        int loop = 0;
        for (StaffEntity staff : staffEntityArrayList){
            if (staff.getNama().equals(nama) && staff.getPassword().equals(password)){
                break;
            }else {
                loop++;
            }
        }
        return loop;
    }

    public StaffEntity getStaffEntityArrayList(int index){
        return staffEntityArrayList.get(index);
    }
}
