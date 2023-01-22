package controller;

import entity.BukuEntity;
import entity.InputBukuEntity;

import javax.swing.table.DefaultTableModel;

public class BukuController {
    int indexInput = 0;

    public BukuController(){
    }

    public BukuEntity getData(){
        return ModelController.bukuModel.getBukuEntityArrayList(indexInput);
    }

    public void inputdatabuku(BukuEntity bukuEntity,boolean  IsVerified){
        ModelController.inputBukuModel.insertDataBuku(new InputBukuEntity(bukuEntity,IsVerified));
    }

    public void insert(String idbuku, String judul, String author, String genre){
        ModelController.bukuModel.insert(new BukuEntity(idbuku,judul,author,genre));
    }

    public BukuEntity bukuEntity(){
        return ModelController.bukuModel.getBukuEntityArrayList(indexInput);
    }

    public int cekDataBuku(String judul){
        int cek = ModelController.inputBukuModel.cekData(null,judul);
        return cek;
    }

    public InputBukuEntity showDataBuku(int index){
        return ModelController.inputBukuModel.showInputan(index);
    }

    public BukuEntity setBukuEntity(int index){
        return ModelController.bukuModel.getBukuEntityArrayList(index);
    }

    public DefaultTableModel inputBuku(){
        DefaultTableModel dtminputBuku = new DefaultTableModel();
        Object[] kolom = {"Id Buku","Judul","Author","Genre","Verified"};
        dtminputBuku.setColumnIdentifiers(kolom);
        int size = ModelController.inputBukuModel.getInputBukuEntityArrayList().size();
        String verif = null;
        for (int i=0;i<size;i++){
            if (ModelController.inputBukuModel.getInputBukuEntityArrayList().get(i).isAccStaff()==false){
              verif = "no";
            }else {
                verif = "yes";
            }
            Object [] data = new Object[5];
            data[0] = ModelController.inputBukuModel.getInputBukuEntityArrayList().get(i).getBukuEntity().getIdbuku();
            data[1] = ModelController.inputBukuModel.getInputBukuEntityArrayList().get(i).getBukuEntity().getJudul();
            data[2] = ModelController.inputBukuModel.getInputBukuEntityArrayList().get(i).getBukuEntity().getAuthor();
            data[3] = ModelController.inputBukuModel.getInputBukuEntityArrayList().get(i).getBukuEntity().getGenre();
            data[4] = verif;
            dtminputBuku.addRow(data);
        }
        return dtminputBuku;
    }
}
