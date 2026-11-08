import java.util.ArrayList;

class Diem2D {
    protected double x;
    protected double y;

    Diem2D() {
        x = 0;
        y = 0;
    }

    Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double tinhKhoangCach(Diem2D d) {
        double dx = x - d.x;
        double dy = y - d.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    Diem2D timDoiXung() {
        return new Diem2D(-x, -y);
    }

    void tinhTien(double dx, double dy) {
        x += dx;
        y += dy;
    }

    void xuat() {
        System.out.println("Diem 2D: (" + x + ", " + y + ")");
    }
}

class Diem3D extends Diem2D {
    protected double z;

    Diem3D() {
        super();
        z = 0;
    }

    Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    double tinhKhoangCach(Diem3D d) {
        double dx = x - d.x;
        double dy = y - d.y;
        double dz = z - d.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    Diem3D timDoiXung() {
        return new Diem3D(-x, -y, -z);
    }

    void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy);
        z += dz;
    }

    void xuat() {
        System.out.println("Diem 3D: (" + x + ", " + y + ", " + z + ")");
    }
}

public class Bai2 {
    public static void main(String[] args) {
        ArrayList<Diem2D> ds = new ArrayList<>();

        ds.add(new Diem2D(0, 0));
        ds.add(new Diem2D(3, 4));
        ds.add(new Diem3D(0, 0, 0));
        ds.add(new Diem3D(1, 2, 2));

        ArrayList<Diem2D> ds2D = new ArrayList<>();
        ArrayList<Diem3D> ds3D = new ArrayList<>();

        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i) instanceof Diem3D) {
                ds3D.add((Diem3D) ds.get(i));
            } else {
                ds2D.add(ds.get(i));
            }
        }

        double tong2D = 0;
        for (int i = 0; i < ds2D.size() - 1; i++) {
            tong2D += ds2D.get(i).tinhKhoangCach(ds2D.get(i + 1));
        }

        double tong3D = 0;
        for (int i = 0; i < ds3D.size() - 1; i++) {
            tong3D += ds3D.get(i).tinhKhoangCach(ds3D.get(i + 1));
        }

        System.out.println("Tong khoang cach cac diem 2D: " + tong2D);
        System.out.println("Tong khoang cach cac diem 3D: " + tong3D);

        int n = ds.size();
        for (int i = 0; i < n; i++) {
            ds.add(ds.get(i).timDoiXung());
        }

        System.out.println("Danh sach cac diem sau khi them diem doi xung:");
        for (int i = 0; i < ds.size(); i++) {
            ds.get(i).xuat();
        }
    }
}

