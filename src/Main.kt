import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Nhập số lượng phân số: ")
    val n = scanner.nextLine().toInt()
    val arr = Array(n) { PhanSo(0, 1) }

    // Nhập mảng phân số
    for (i in arr.indices) {
        println("Nhập phân số thứ ${i + 1}:")
        arr[i].nhap(scanner)
    }

    // In mảng phân số
    println("\nMảng phân số vừa nhập:")
    arr.forEach { it.xuat() }

    // Tối giản và in lại
    println("\nMảng phân số sau khi tối giản:")
    arr.forEach {
        it.toiGian()
        it.xuat()
    }

    // Tính tổng các phân số
    var tong = PhanSo(0, 1)
    for (ps in arr) {
        tong = tong.cong(ps)
    }
    println("\nTổng các phân số:")
    tong.xuat()

    // Tìm phân số lớn nhất
    var maxPS = arr[0]
    for (ps in arr) {
        if (ps.soSanh(maxPS) == 1) {
            maxPS = ps
        }
    }
    print("\nPhân số lớn nhất: ")
    maxPS.xuat()

    // Sắp xếp giảm dần
    arr.sortWith { a, b -> b.soSanh(a) }
    println("\nMảng sau khi sắp xếp giảm dần:")
    arr.forEach { it.xuat() }
}