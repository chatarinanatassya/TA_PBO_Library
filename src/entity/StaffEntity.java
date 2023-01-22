package entity;

import java.util.Date;

public  class StaffEntity {
    protected String id,nama,notelp,password;
    protected Date tanggalLahir;

    public StaffEntity(String id, String nama, String notelp, String password, Date tanggalLahir) {
        this.id = id;
        this.nama = nama;
        this.notelp = notelp;
        this.password = password;
        this.tanggalLahir = tanggalLahir;
    }

    public StaffEntity() {
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public String getPassword() {
        return password;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}
