import java.util.*
import kotlin.math.abs

class PhanSo(var tu: Int, var mau: Int) {

    // Nhập phân số từ bàn phím
    fun nhap(scanner: Scanner) {
        do {
            print("Nhập tử số: ")
            tu = scanner.nextLine().toInt()
            print("Nhập mẫu số: ")
            mau = scanner.nextLine().toInt()
            if (mau == 0) {
                println("Mẫu số phải khác 0, nhập lại!")
            }
        } while (mau == 0)
    }

    // In phân số
    fun xuat() {
        println("$tu/$mau")
    }

    // Rút gọn phân số
    fun toiGian() {
        val gcd = gcd(abs(tu), abs(mau))
        tu /= gcd
        mau /= gcd
        if (mau < 0) {  // đưa dấu âm về tử số
            tu = -tu
            mau = -mau
        }
    }

    // Hàm tìm UCLN
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    // So sánh với phân số khác (-1, 0, 1)
    fun soSanh(ps: PhanSo): Int {
        val left = tu * ps.mau
        val right = ps.tu * mau
        return when {
            left < right -> -1
            left > right -> 1
            else -> 0
        }
    }

    // Cộng phân số khác
    fun cong(ps: PhanSo): PhanSo {
        val tuMoi = tu * ps.mau + ps.tu * mau
        val mauMoi = mau * ps.mau
        val kq = PhanSo(tuMoi, mauMoi)
        kq.toiGian()
        return kq
    }
}