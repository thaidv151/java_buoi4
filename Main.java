import java.util.Scanner;

class Nguoi {
    String hoTen;
    int tuoi;

    void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        tuoi = sc.nextInt();
    }

    void xuat() {
        System.out.print("Ho ten: " + hoTen + ", Tuoi: " + tuoi);
    }
}

class NhanVien extends Nguoi {
    int snct;
    double hsl;

    void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap so nam cong tac: ");
        snct = sc.nextInt();
        System.out.print("Nhap he so luong: ");
        hsl = sc.nextDouble();
        sc.nextLine();
    }

    double tinhTienLuong() {
        double lcb = 1.5;
        double phucap = 0.2 * snct;
        double tienluong = lcb * hsl + phucap;
        return tienluong;
    }

    void xuat() {
        super.xuat();
        System.out.println(", So nam cong tac: " + snct + ", He so luong: " + hsl + ", Tien luong: " + tinhTienLuong());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so nhan vien: ");
        int n = sc.nextInt();
        sc.nextLine();

        NhanVien[] ds = new NhanVien[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap nhan vien thu " + (i + 1) + ":");
            ds[i] = new NhanVien();
            ds[i].nhap(sc);
        }

        NhanVien max = ds[0];
        for (int i = 1; i < n; i++) {
            if (ds[i].snct > max.snct) {
                max = ds[i];
            }
        }

        System.out.println("Nhan vien co so nam cong tac nhieu nhat:");
        max.xuat();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ds[i].tinhTienLuong() < ds[j].tinhTienLuong()) {
                    NhanVien tg = ds[i];
                    ds[i] = ds[j];
                    ds[j] = tg;
                }
            }
        }

        System.out.println("Danh sach nhan vien theo thu tu luong tu cao den thap:");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }
}
