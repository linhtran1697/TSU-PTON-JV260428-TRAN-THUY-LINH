package ra.presentation;

public class LibraryManagement {
    private static final Scanner scanner =
            new Scanner(System.in);
    private static final BorrowCardDAO dao =
            new BorrowCardDAO ();
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern (
                    "dd/MM/yyyy HH:mm"
            );
    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "=================LIBRARY MANAGEMENT=============="
            );
            System.out.println(
                    "1.DANH SÁCH TẤT CẢ PHIẾU MƯỢN"
            );
            System.out.println(
                    "2.THÊM MỚI PHIẾU MƯỢN"
            );
            System.out.println(
                    "3.CẬP NHẬT PHIẾU MƯỢN"
            );
            System.out.println(
                    "4.XOÁ PHIẾU MƯỢN"
            );
            System.out.println(
                    "5.TÌM KIẾM PHIẾU MƯỢN THEO TÊN ĐỘC GIẢ"
            );
            System.out.println(
                    "5.TÌM KIẾM PHIẾU MƯỢN THEO TÊN SÁCH"
            );
            System.out.println(
                    "6.THOÁT"
            );
            int choice =
                    inputInteger(
                            "Lựa chọn của bạn:"
                    );

            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    addBorrowCard();
                    break;
                case 3:
                    uppdateBorrowCard();
                    break;
                case 4:
                    deleteBorrowCard();
                    break;
                case 5:
                    seachbyBorrower();
                    break;
                case 6:
                    seachbyBookTitle();
                    break;
                case 7:
                    System.out.println(
                            "ĐÃ THOÁT CHƯƠNG TRÌNH"
                    );
                    scanner.close();
                    return;
                default:
                    System.out.println(
                            "Vui lòng chọn từ 1 đến 7."
                    );
            }
        }
    }

    private static void displayList (
            List<BorrowCard> List
                    ) {
        if (list.isEmpty()) {
            System.out.println(
                    "Không có dữ liệu"
            );
            return;
        }
        System.out.printf (
                "%-5s %-25s %-20s %-18s %18s %10s %-12S%n",
                "ID",
                "Tên sách",
                "ĐỘC GIẢ",
                "Ngày mượn",
                "Hạn trả",
                "SỐ LƯỢNG",
                "TRẠNG THÁI"
        );
        for (BorrowCard card : list) {
            System.out.printf (
                    "%-5s %-25s %-20s %-18s %18s %10s %-12S%n",
                    card.getCardId(),ư
                    card.BookTitle(),
                    card.getBorrowerName(),
                    card.getBorrowDate().format(FORMATTER)
                    card.getCardId(),
                    card.getCardId(),
                    card.getCardId(),
        }
}
}

