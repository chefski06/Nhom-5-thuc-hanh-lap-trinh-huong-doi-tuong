import java.util.ArrayList;
import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String hoTen;
    private int tuoi;
    private double diemTB;

    public SinhVien(String maSV, String hoTen, int tuoi, double diemTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }

    @Override
    public String toString() {
        return "Mã SV: " + maSV + ", Họ tên: " + hoTen +
               ", Tuổi: " + tuoi + ", Điểm TB: " + diemTB;
    }
}

public class QuanLySinhVien {
    private static ArrayList<SinhVien> danhSach = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {
            menu();
            System.out.print("Nhập lựa chọn: ");
            chon = scanner.nextInt();
            scanner.nextLine(); // bỏ ký tự xuống dòng
            switch (chon) {
                case 1: themSinhVien(); break;
                case 2: hienThi(); break;
                case 3: timKiem(); break;
                case 4: xoaSinhVien(); break;
                case 5: System.out.println("Thoát chương trình!"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 5);
    }

    public static void menu() {
        System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Tìm sinh viên theo mã số");
        System.out.println("4. Xóa sinh viên theo mã số");
        System.out.println("5. Thoát");
    }

    public static void themSinhVien() {
        System.out.print("Nhập mã SV: ");
        String ma = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int tuoi = scanner.nextInt();
        System.out.print("Nhập điểm TB: ");
        double diem = scanner.nextDouble();
        scanner.nextLine();

        SinhVien sv = new SinhVien(ma, ten, tuoi, diem);
        danhSach.add(sv);
        System.out.println(">> Thêm sinh viên thành công!");
    }

    public static void hienThi() {
        System.out.println("\n--- Danh sách sinh viên ---");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (SinhVien sv : danhSach) {
                System.out.println(sv);
            }
        }
    }

    public static void timKiem() {
        System.out.print("Nhập mã SV cần tìm: ");
        String ma = scanner.nextLine();
        for (SinhVien sv : danhSach) {
            if (sv.getMaSV().equals(ma)) {
                System.out.println(">> Tìm thấy: " + sv);
                return;
            }
        }
        System.out.println(">> Không tìm thấy sinh viên!");
    }

    public static void xoaSinhVien() {
        System.out.print("Nhập mã SV cần xóa: ");
        String ma = scanner.nextLine();
        for (SinhVien sv : danhSach) {
            if (sv.getMaSV().equals(ma)) {
                danhSach.remove(sv);
                System.out.println(">> Đã xóa thành công!");
                return;
            }
        }
        System.out.println(">> Không tìm thấy sinh viên!");
    }
}
