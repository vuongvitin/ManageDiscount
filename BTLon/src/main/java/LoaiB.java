import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LoaiB extends KhuyenMai {
    private List<String> tangKem;
    public LoaiB(String ngayHetHan) throws ParseException {
        Random rand = new Random();
        int ma = rand.nextInt(8999) + 1000;
        this.maKm = String.format("B%04d", ma);
        this.tangKem = new ArrayList<>();


        this.ngayTao = new Date();
        Date d = F.parse(ngayHetHan);
        this.ngayHetHieuLuc = d;
    }

//    @Override
//    public void hienThi() {
//        super.hienThi();
//    }

    public void themTangKem(String tangKem){
        this.tangKem.add(tangKem);
    }

    public List<String> getTangKem() {
        return tangKem;
    }

    public void setTangKem(List<String> tangKem) {
        this.tangKem = tangKem;
    }
}
