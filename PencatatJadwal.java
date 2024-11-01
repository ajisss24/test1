import java.util.ArrayList;
import java.util.Scanner;

public class PencatatJadwal {
    private final ArrayList<String> jadwal = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PencatatJadwal app = new PencatatJadwal();
        app.jalankanProgram();
    }

    // Fungsi utama untuk menjalankan program
    public void jalankanProgram() {
        boolean isRunning = true;
        while (isRunning) {
            tampilkanMenu();
            int pilihan = bacaPilihan();
            isRunning = prosesPilihan(pilihan);
        }
    }

    // Menampilkan menu kepada pengguna
    private void tampilkanMenu() {
        System.out.println("=== PENCATATAN JADWAL HARIAN ===");
        System.out.println("1. Tambah Jadwal");
        System.out.println("2. Hapus Jadwal");
        System.out.println("3. Lihat Jadwal");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
    }

    // Membaca pilihan dengan validasi input
    private int bacaPilihan() {
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka. Coba lagi:");
            scanner.next(); // Konsumsi input yang salah
        }
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline
        return pilihan;
    }

    // Memproses pilihan pengguna
    private boolean prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1 -> tambahJadwal();
            case 2 -> hapusJadwal();
            case 3 -> tampilkanJadwal();
            case 4 -> {
                System.out.println("Keluar dari program.");
                return false;
            }
            default -> System.out.println("Pilihan tidak valid.");
        }
        return true;
    }

    // Menambahkan jadwal ke daftar
    private void tambahJadwal() {
        System.out.print("Masukkan jadwal: ");
        String kegiatan = scanner.nextLine();
        jadwal.add(kegiatan);
        System.out.println("Jadwal '" + kegiatan + "' ditambahkan.");
    }

    // Menghapus jadwal dari daftar
    private void hapusJadwal() {
        System.out.print("Masukkan jadwal yang ingin dihapus: ");
        String kegiatan = scanner.nextLine();
        if (jadwal.remove(kegiatan)) {
            System.out.println("Jadwal '" + kegiatan + "' dihapus.");
        } else {
            System.out.println("Jadwal tidak ditemukan.");
        }
    }

    // Menampilkan semua jadwal
    private void tampilkanJadwal() {
        System.out.println("Jadwal Harian:");
        if (jadwal.isEmpty()) {
            System.out.println("(Tidak ada jadwal)");
        } else {
            for (String kegiatan : jadwal) {
                System.out.println("- " + kegiatan);
            }
        }
    }
}