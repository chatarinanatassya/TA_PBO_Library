package entity;

public class InputBukuEntity {

   protected BukuEntity bukuEntity;
   protected boolean accStaff;

    public InputBukuEntity(BukuEntity bukuEntity, boolean accStaff) {
        this.bukuEntity = bukuEntity;
        this.accStaff = accStaff;
    }

    public BukuEntity getBukuEntity() {
        return bukuEntity;
    }

    public boolean isAccStaff() {
        return accStaff;
    }
}
