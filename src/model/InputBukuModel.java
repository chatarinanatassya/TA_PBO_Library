package model;

import entity.InputBukuEntity;

import java.util.ArrayList;

public class InputBukuModel implements Model {
    public ArrayList<InputBukuEntity> inputBukuEntityArrayList;
    public InputBukuModel(){
        inputBukuEntityArrayList = new ArrayList<InputBukuEntity>();
    }

    public void insertDataBuku(InputBukuEntity inputBuku){
        inputBukuEntityArrayList.add(inputBuku);
    }

    public ArrayList<InputBukuEntity> getInputBukuEntityArrayList(){
        return inputBukuEntityArrayList;
    }

    public int size(){
        return inputBukuEntityArrayList.size();
    }

    @Override
    public int cekData(String idbuku, String judul){
        int loop = 0;
        if (inputBukuEntityArrayList.size() == 0){
            loop = -1; //data kosong
        }else {
            for (int i = 0; i < inputBukuEntityArrayList.size(); i++){
                if (inputBukuEntityArrayList.get(i).getBukuEntity().getJudul().equals(judul)){
                   loop = i;
                   break;
                }else {
                    loop = -2;
                }
            }
        }
        return loop;
    }

    public InputBukuEntity showInputan(int index){
        return inputBukuEntityArrayList.get(index);
    }

    public void UpdateIsVerified(int index, InputBukuEntity inputBukuEntity){
        inputBukuEntityArrayList.set(index, inputBukuEntity);
    }
}
