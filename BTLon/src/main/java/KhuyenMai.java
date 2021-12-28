import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class KhuyenMai{
    protected static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    protected static final Scanner S = new Scanner(System.in);
    protected String maKm;
    protected Date ngayTao;
    protected Date ngayHetHieuLuc;

    public void hienThi(){
        System.out.printf("Ma khuyen mai: %s\n", this.maKm);
//        System.out.printf("Ngay tao: %s\n", F.format(this.ngayTao));
        System.out.printf("Ngay het han: %s\n", F.format(this.ngayHetHieuLuc));
    }

    public boolean isConHieuLuc(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(this.ngayHetHieuLuc);
        String str = f.format(new Date());
        Date d2 = null;
        try {
            d2 = f.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        c2.setTime(d2);

        long soNgayConHieuLuc = (c1.getTime().getTime() - c2.getTime().getTime())/(24*3600*1000);

        if(soNgayConHieuLuc > 0)
            return true;

        return false;
    }

    public String getMaKm() {
        return maKm;
    }

    public void setMaKm(String maKm) {
        this.maKm = maKm;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayHetHieuLuc() {
        return ngayHetHieuLuc;
    }

    public void setNgayHetHieuLuc(Date ngayHetHieuLuc) {
        this.ngayHetHieuLuc = ngayHetHieuLuc;
    }
}
