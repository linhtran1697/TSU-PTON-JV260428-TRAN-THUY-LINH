package ra.dao;

import ra.entity.BorrowCard;
import ra.util.DBConection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowCardDAO {
    // ======================================
    // 1. DANH SACH TAT CA PHIEU MUON
    // ======================================

    public List <BorrowCard> getALL () {
        List < BorrowCard> list = new ArrayList<>();
        String sql = "CALL sp_get_all_borrow_cards()}";
        try (
                Connection conn = Connection.getConnection();
                CallableStatement call = conn.prepareCall(sql);
                ResultSet rs = call.executeQuery()
                ) {
            while (rs.next()) {
                   list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(
                    "Lỗi lấy danh sách: " + e.getMessage()
            );
        }
        return list;
    }

    // ======================================
    // 2. THEM PHIEU MUON
    // ======================================
    public boolean add(BorrowCard card) {
        String sql =
                "{CALL sp_add_borrow_card(?,?,?,?,?,?)}";
        try
            (
                    Connection conn = Connection.getConnection();
                    CallableStatement call = conn.prepareCall(sql)
                    ) {
            call.setString(
                    1,
                    card.getBookTitle()

            );
            call.setString(
                    2,
                    card.getBorrowerName()
            );
            call.setTimestamp(
                    3,
                    Timestamp.valueOf(card.getBorrowDate())
            );
            call.setTimestamp(
                    4,
                    Timestamp.valueOf(card.getReturnDeadline())
            );
            call.setInt(
                    5,
                    card.getQuantity()
            );
            call.setString(
                    6,
                    card.getStatus()
            );
            call.execute();
            return true;

        } catch ( SQLException e){
            System.out.println(
                    "Lỗi thêm phiếu:" + e.getMessage()
            );
            return false;
        }
    }
    // ======================================
    // 3. CẬP NHẬT PHIEU
    // ======================================
    public boolean update(BorrowCard card) {
        String sql =
                "{CALL sp_update_borrow_card(?,?,?,?,?,?,?)}";

        try ( Connection conn = Connection.getConnection();
              CallableStatement call = conn.prepareCall(sql);
              ) {
            call.setInt(1, card.getCardId()

            );
            call.setString(
                    2,
                    card.getBookTitle()
            );
            call.setString(
                    3,
                    card.getBorrowerName()
            );
            call.setTimestamp(
                    4,
                    Timestamp.valueOf(card.getBorrowDate()
            );
            call.setTimestamp(
                    5,
                    Timestamp.valueOf(card.getReturnDeadline()
            );
            call.setInt(
                    6,
                    card.getQuantity()
            );
            call.setString(
                    7,
                    card.getStatus()
            call.execute();
            return true;

        } catch (SQLException e){
            System.out.println(
                    "Lỗi cập nhật:" + e.getMessage()
            );
            return false;
        }
    }
    // ======================================
    // 4. XOA PHIEU
    // ======================================
    public boolean delete(int cardId) {
        String sql =
                "{CALL sp_delete_borrow_card(?,?,?,?,?,?,?)}";

        try ( Connection conn = Connection.getConnection();
              CallableStatement call = conn.prepareCall(sql);
        ) {
            call.setInt(1, cardId);
            call.execute ();
            return true;
        }
        catch ( SQLException e) {
            System.out.println(
                    "Lỗi xoá:" + e.getMessage()
            );
            return false;
        }
    }
    // ======================================
    // 5. TÌM THEO TÊN ĐỘC GIẢ
    // ======================================
     public List <BorrowCard> searchBorrower (
        String borrowerName
         ) {
        List <BorrowCard> list =
                new ArrayList <>();
        String sql =
                "{CALL sp_search_by_borrower_name(?)}";
        try ( Connection conn = Connection.getConnection();
              CallableStatement call = conn.prepareCall(sql)
        ) {
            call.setString(
                    1,borrowerName
            );
            try (
                    ResultSet rs = call.executeQuery()
            ) {
                while (rs.next()) {
                    System.out.println(
                            "Lỗi tìm kiếm:" + e.getMessage()
                    );
                }
                return list;
            }

            // ======================================
            // 6. TÌM THEO TÊN ĐỘC GIẢ
            // ======================================
        }

    }
}
