import java.text.ParseException;
import java.util.Date;

public class LoaiC extends KhuyenMai{
    private static int dem;
    private String danhMuc;
    private double tyLe;

    public LoaiC(String danhMuc, double tl, String ngayHetHan) throws ParseException {
        this.maKm = String.format("C%04d", ++dem);
        this.setDanhMuc(danhMuc);
        this.setTyLe(tl);

        this.ngayTao = new Date();
        Date d = F.parse(ngayHetHan);
        this.ngayHetHieuLuc = d;
    }

//    @Override
//    public void hienThi() {
//        super.hienThi();
//    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public double getTyLe() {
        return tyLe;
    }

    public void setTyLe(double tyLe) {
        this.tyLe = tyLe;
    }
}
