import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SanPham {
    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner S = new Scanner(System.in);
    public static int dem;
    private int maSp = ++dem;
    private String tenSp;
    private double gia;
    private String danhMuc;
    private List<KhuyenMai> khuyenMai;

    public SanPham(){
        this.setKhuyenMai(new ArrayList<>());
    }

    public SanPham(String tenSp, String dm, double gia){
        this.tenSp = tenSp;
        this.danhMuc = dm;
        this.gia = gia;
        this.setKhuyenMai(new ArrayList<>());
    }

    public int demKmConHan(){
        int dem = 0;
        for(KhuyenMai km: this.khuyenMai){
            if(km.isConHieuLuc() == true)
                dem++;
        }

        return dem;
    }

    public void xoaKMHetHan(){
        this.khuyenMai.removeIf(h -> h.getNgayHetHieuLuc().compareTo(new Date()) == -1);
    }

    public void themSp(){
        System.out.print("Nhap ten san pham: ");
        this.tenSp = S.nextLine();
        System.out.print("Nhap gia san pham: ");
        this.gia = Double.parseDouble(S.nextLine());
        System.out.print("Nhap danh muc san pham: ");
        this.danhMuc = S.nextLine();
    }

    public void themKmA() throws ParseException {
        System.out.print("Nhap ty le: ");
        double tyLe = Double.parseDouble(S.nextLine());
        System.out.print("Nhap ngay het han(dd/MM/yyyy): ");
        String ngayHetHan = S.nextLine();

        KhuyenMai kmA = new LoaiA(tyLe, ngayHetHan);
        this.khuyenMai.add(kmA);
    }

    public void themKmB() throws ParseException {
        System.out.print("Nhap ngay het han(dd/MM/yyyy): ");
        String ngayHetHan = S.nextLine();

        KhuyenMai kmB = new LoaiB(ngayHetHan);
        this.khuyenMai.add(kmB);
    }

    public void themKmC() throws ParseException {
        System.out.print("Nhap danh muc: ");
        String danhMuc = S.nextLine();
        System.out.print("Nhap ty le: ");
        double tyLe = Double.parseDouble(S.nextLine());
        System.out.print("Nhap ngay het han(dd/MM/yyyy): ");
        String ngayHetHan = S.nextLine();

        KhuyenMai kmC = new LoaiC(danhMuc, tyLe, ngayHetHan);
        this.khuyenMai.add(kmC);
    }

    public void themKM(KhuyenMai km){
        this.getKhuyenMai().add(km);
    }

    public void hienThi(){
        System.out.println("======SAN PHAM======");
        System.out.printf("Ma san pham:%d\n", this.maSp);
        System.out.printf("Ten san pham:%s\n", this.tenSp);
        System.out.printf("Gia:%.0f\n", this.gia);
        System.out.printf("Thuoc danh muc:%s\n", this.danhMuc);
        System.out.println("CAC MA KHUYEN MAI");

        if(this.khuyenMai.size() > 0)
            this.khuyenMai.forEach(km -> km.hienThi());
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public List<KhuyenMai> getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(List<KhuyenMai> khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
}
