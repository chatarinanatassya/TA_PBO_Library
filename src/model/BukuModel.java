package model;

import entity.BukuEntity;

import java.util.ArrayList;

public class BukuModel implements Model {
    public ArrayList<BukuEntity> bukuEntityArrayList;
    public BukuModel(){
        bukuEntityArrayList = new ArrayList<BukuEntity>();
    }

    public void insert(BukuEntity bukuEntity){
        bukuEntityArrayList.add(bukuEntity);
    }

    public int size(){
        return bukuEntityArrayList.size();
    }


    @Override
    public int cekData(String idbuku,String judul){
        int loop = 0;
        if (bukuEntityArrayList.size() == 0){
            loop = -1; // data kosong
        }else {
            for (int i = 0; i < bukuEntityArrayList.size(); i++){
                if (bukuEntityArrayList.get(i).getIdbuku().equals(idbuku)&&bukuEntityArrayList.get(i).getJudul().equals(judul)){
                    loop = i;
                    break;
                }else {
                    loop = -2;
                }
            }
        }
        return loop;
    }

    public BukuEntity getBukuEntityArrayList(int index){
        return bukuEntityArrayList.get(index);
    }
}
