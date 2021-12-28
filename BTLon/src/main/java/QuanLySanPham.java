import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLySanPham {
    private List<SanPham> ds = new ArrayList<>();

    public void sapXepGiamDan(){
        this.ds.sort((b1, b2) -> -(b1.demKmConHan() - b2.demKmConHan()));
    }

    public void xemKm(int maSp, String tensp){
        if(maSp != 0 && tensp != null)
        {
            SanPham sp = this.ds.stream().filter(s -> s.getMaSp() == maSp).findFirst().get();

            System.out.printf("THONG TIN KHUYEN MAI CUA SAN PHAM CO MA SAN PHAM: %d\n", sp.getMaSp());
            sp.getKhuyenMai().forEach(km -> km.hienThi());
        }else if(tensp != null && maSp == 0){
            SanPham sp = this.ds.stream().filter(s -> s.getTenSp().contains(tensp)).findFirst().get();

            System.out.printf("THONG TIN KHUYEN MAI CUA SAN PHAM TEN: %s\n", sp.getTenSp());
            sp.getKhuyenMai().forEach(km -> km.hienThi());
        }
    }

    public List<KhuyenMai> cacKmConNgayHetHan(int x) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        List<KhuyenMai> kq = new ArrayList<>();

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar. getInstance();

        for(SanPham sp: this.ds){
            for (int i = 0;i<sp.getKhuyenMai().size(); i++){
                c1.setTime(sp.getKhuyenMai().get(i).getNgayHetHieuLuc());
                String str = f.format(new Date());
                Date d2 = f.parse(str);

                c2.setTime(d2);


                long soNgayConHieuLuc = (c1.getTime().getTime() - c2.getTime().getTime())/(24*3600*1000);

                if(soNgayConHieuLuc == x)
                    kq.add(sp.getKhuyenMai().get(i));
            }
        }

        return kq;
    }

    public void xoaKMHetHan(){
        for(SanPham sp: this.ds){
            sp.xoaKMHetHan();
        }
    }

    public void hienThi(){
        if(this.ds.size() > 0)
            this.ds.forEach(sp -> sp.hienThi());
        else
            System.out.println("Chua co san pham nao trong danh sach!!!");
    }

    public List<SanPham> timKiemTheoTen(String kw){
        return this.ds.stream().filter(sp -> sp.getTenSp().contains(kw)).collect(Collectors.toList());
    }

    public List<SanPham> timKiemTheoGia(double tuGia, double denGia){
        return this.ds.stream().filter(sp ->{
            if(sp.getGia() >= tuGia && sp.getGia() <= denGia)
                return true;
            return false;
        }).collect(Collectors.toList());
    }

    public List<SanPham> timKiemTheoLoaiKM(String loaiKm) throws ClassNotFoundException {
        Class myClass = Class.forName(loaiKm);

        List<SanPham> kq = new ArrayList<>();

        for(SanPham s: this.ds){
            s.getKhuyenMai().forEach(k ->{
                if(myClass.isInstance(k) == true){
                    kq.add(s);
            }
            });
        }

        return kq;
    }

    public void themKm(int maSp, String loaiKm) throws ParseException {
        if(loaiKm.equals("A"))
            this.ds.stream().filter(sp -> sp.getMaSp() == maSp).findFirst().get().themKmA();
        if(loaiKm.equals("B"))
            this.ds.stream().filter(sp -> sp.getMaSp() == maSp).findFirst().get().themKmB();
        if(loaiKm.equals("C"))
            this.ds.stream().filter(sp -> sp.getMaSp() == maSp).findFirst().get().themKmC();
    }

    public void themSp(SanPham sp){
        this.ds.add(sp);
    }

    public void themSp(){
        SanPham sp = new SanPham();

        sp.themSp();

        this.ds.add(sp);
    }

    public List<SanPham> getDs() {
        return ds;
    }

    public void setDs(List<SanPham> ds) {
        this.ds = ds;
    }
}
