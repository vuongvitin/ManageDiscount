import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoaiA extends KhuyenMai {
    private static int dem;
    private double tyLe;

    public LoaiA(double tyle, String ngayHetHan) throws ParseException {
        this.tyLe = tyle;
        this.maKm = String.format("A%02d", ++dem);
        this.ngayTao = new Date();
        Date d = F.parse(ngayHetHan);
        this.ngayHetHieuLuc = d;
    }

    public double getTyLe() {
        return tyLe;
    }

    public void setTyLe(double tyLe) {
        this.tyLe = tyLe;
    }
}
