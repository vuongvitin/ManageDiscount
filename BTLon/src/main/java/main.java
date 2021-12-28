import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;
import java.io.*;

public class main {
    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {

        Scanner S = new Scanner(System.in);
        int chon;
        QuanLySanPham ql = new QuanLySanPham();

        do{
            System.out.println(System.lineSeparator().repeat(50));
            
            System.out.println("========MENU========");
            System.out.println("1. Them san pham vao danh sach");
            System.out.println("2. Tim kiem san pham theo TEN");
            System.out.println("3. Tim kiem san pham theo KHOANG GIA");
            System.out.println("4. Tim kiem san pham theo LOAI KHUYEN MAI");
            System.out.println("5. THEM KHUYEN MAI");
            System.out.println("6. XOA khuyen mai HET HAN");
            System.out.println("7. Cac khuyen mai con X ngay het hieu luc");
            System.out.println("8. Thong tin khuyen mai cua san pham chi dinh");
            System.out.println("9. Sap xep khuyen mai giam dan theo so luong Khuyen mai con hieu luc");
            System.out.println("10. Xem thong tin cac san pham");
            System.out.println("11. DUNG CHUONG TRINH");
            System.out.print("Ban chon: ");
            chon = Integer.parseInt(S.nextLine());

            switch (chon){
                case 1:
                    ql.themSp();
                    break;
                case 2:
                    System.out.print("Nhap ten San pham: ");
                    String tenSp = S.nextLine();
                    System.out.println("======THONG TIN SAN PHAM TIM KIEM======");
                    ql.timKiemTheoTen(tenSp).forEach(sp -> sp.hienThi());

                    break;
                case 3:
                    System.out.print("Gia tu: ");
                    double tu = Double.parseDouble(S.nextLine());
                    System.out.print("Den: ");
                    double den = Double.parseDouble(S.nextLine());
                    System.out.println("======THONG TIN SAN PHAM TIM KIEM======");
                    ql.timKiemTheoGia(tu, den).forEach(sp -> sp.hienThi());
                    break;
                case 4:
                    System.out.print("Nhap loai khuyen mai(LoaiA/LoaiB/LoaiC): ");
                    String loai = S.nextLine();

                    System.out.println("======THONG TIN SAN PHAM TIM KIEM======");
                    ql.timKiemTheoLoaiKM(loai).forEach(sp -> sp.hienThi());
                    break;
                case 5:

                    System.out.print("Nhap loai khuyen mai(A/B/C): ");
                    String loaiKm = S.nextLine();

                    System.out.print("Nhap ma san pham: ");
                    int maSp = Integer.parseInt(S.nextLine());

                    ql.themKm(maSp, loaiKm);
                    break;
                case 6:
                    System.out.print("Xoa thanh cong!!");
                    ql.xoaKMHetHan();
                    break;
                case 7:
                    System.out.print("Nhap X ngay het hieu luc: ");
                    int x = Integer.parseInt(S.nextLine());

                    if(ql.cacKmConNgayHetHan(x).size() > 0)
                        ql.cacKmConNgayHetHan(x).forEach(km -> km.hienThi());
                    else
                        System.out.printf("Khong co khuyen mai nao con %d het han", x);
                    break;
                case 8:
                    int maSp2 = 0;
                    String tenSp2 = null;
                    int chon2 = 0;
                    do{
                        System.out.println("Ban muon tim kiem theo???");
                        System.out.println("1. Ma san pham");
                        System.out.println("2. Ten san pham");
                        System.out.println("3. Thoat");
                        System.out.print("Ban chon:");
                        chon2 = Integer.parseInt(S.nextLine());
                    }while (chon2 < 1 && chon2 > 2);

                    switch (chon2)
                    {
                        case 1:
                            System.out.print("Nhap ma san pham: ");
                            maSp2 = Integer.parseInt(S.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ten san pham: ");
                            tenSp2 = S.nextLine();
                            break;
                        default:
                            System.out.println("Thoat tim kiem!");
                    }
                    ql.xemKm(maSp2, tenSp2);

                    break;
                case 9:
                    ql.sapXepGiamDan();
                    System.out.println("DA SAP XEP THANH CONG!!");
                    break;
                case 10:
                    ql.hienThi();
                    break;

                default: {
                    System.out.println("Thoat\n");
                }
            }

            System.in.read();

        }while(chon >= 1 && chon <= 10);

//        SanPham sp1 = new SanPham("Mi 3 mien", "Tap hoa", 3000);
//        SanPham sp2 = new SanPham("Quat may YanFan", "Noi that", 500000);
//        SanPham sp3 = new SanPham("Dau goi Clean", "Do dung hang ngay", 35000);
//
//        sp1.themKM(new LoaiA(5, "27/12/2021"));
//        sp1.themKM(new LoaiA(5, "31/12/2021"));
//        sp1.themKM(new LoaiA(6, "1/7/2018"));
//        sp1.themKM(new LoaiC("Tap hoa", 3, "27/1/2022"));
//
//        LoaiB kmB = new LoaiB("1/5/2022");
//        kmB.themTangKem("NUOC HOA DUNG THU");
//        sp2.themKM(kmB);
//
//        KhuyenMai kmC = new LoaiC("Tap hoa", 3,"1/7/2025");
//
//        sp3.themKM(kmC);
//        sp3.themKM(new LoaiC("Do dung hang ngay", 3,"2/8/2022"));
//
//        QuanLySanPham ql = new QuanLySanPham();
//        ql.themSp(sp1);
//        ql.themSp(sp2);
//        ql.themSp(sp3);
//
//
//
//        System.out.println("======CAC SAN PHAM======");
//        ql.hienThi();
//
//        System.out.println("======TIM KIEM THEO TEN======");
//        ql.timKiemTheoTen("m").forEach(s -> s.hienThi());

//        System.out.println("======TIM KIEM THEO KHOANG GIA======");
//        ql.timKiemTheoGia(35000, 600000).forEach(s -> s.hienThi());
//
//        System.out.println("======TIM KIEM THEO LOAI KHUYEN MAI======");
//        ql.timKiemTheoLoaiKM("LoaiC").forEach(s -> s.hienThi());
//
////        System.out.println("======XOA KHUYEN MAI HET HAN=======");
////        ql.xoaKMHetHan();
////        ql.hienThi();
//
//        System.out.println("======KHUYEN MAI CON 3 NGAY HET HAN=======");
//        ql.cacKmNgayHetHan(3).forEach(km -> km.hienThi());
//
//        ql.xemKm(0, "Clean");
//
//        System.out.println("======SAP XEP GIAM DAN=======");
//        ql.sapXepGiamDan();
//
//        ql.hienThi();

//        SanPham spa = new SanPham();
//
//        spa.themSp();
//        spa.themKmA();
//        spa.themKmB();
//        spa.themKmC();
//
//        spa.hienThi();
//
//        SanPham spb = new SanPham();
//
//        spb.themSp();
//        spb.themKmA();
//        spb.themKmB();
//        spb.themKmC();
//
//        spb.hienThi();

    }
}