package LibraryManagement.model;

import LibraryManagement.entity.Librarian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static LibraryManagement.model.BookDAOImpl.GET_BOOK_BY_ID;
import static LibraryManagement.model.StudentDAOImpl.GET_STUDENT_BY_ID;

public class LibraryDaoImpl implements LibraryDAO{
    public static Connection connection;
    public static Connection openConnection() throws SQLException{
        connection = MySqlConnect.getMySQLConnection();
        return connection;
    }
    public static PreparedStatement pstm;
    public static PreparedStatement openPrepareStatement(String query) throws SQLException{
        pstm = openConnection().prepareStatement(query);
        return pstm;
    }
    public static void exUpdate() throws SQLException{
        pstm.executeUpdate();
    }
    public static ResultSet exQuery()throws SQLException{
        ResultSet rs = pstm.executeQuery();
        return rs;
    }



    private final String GET_ALL_LIBRARIAN = "SELECT * FROM librarian";
    private final String GET_LIBARIAN_BY_ID = "SELECT * FROM librarian WHERE id = ?";
    private final String CREATE_LIBRARIAN = "INSERT INTO librarian(book_id,student_id) VALUES(?,?)";
    private final String UPDATE_LIBRARIAN = "UPDATE librarian SET book_id = ?, student_id = ? where id = ?";
    private final String DELETE_LIBRARIAN = "DELETE FROM librarian WHERE student_id = ? and book_id = ?";



    @Override
    public void createLibrarian(Librarian librarian) throws SQLException {
        openPrepareStatement(CREATE_LIBRARIAN);
        pstm.setInt(1,librarian.getBook_id());
        pstm.setInt(2,librarian.getStudent_id());
        exUpdate();
    }

    @Override
    public ArrayList<Librarian> getAllLibrarian() throws SQLException {
        ArrayList<Librarian> list = new ArrayList<>();
        openPrepareStatement(GET_ALL_LIBRARIAN);
        ResultSet rs = exQuery();

        while (rs.next()) {
            Librarian librarian = new Librarian();
            int bookId = rs.getInt(2);
            int studentId = rs.getInt(3);
            librarian.setBook_id(bookId);
            librarian.setStudent_id(studentId);

            openPrepareStatement(GET_BOOK_BY_ID);
            pstm.setInt(1, bookId);
            ResultSet resultSet = exQuery();
            if (resultSet.next()) {
                String bookName = resultSet.getString(2);
                librarian.setBook_name(bookName);
            }
            openPrepareStatement(GET_STUDENT_BY_ID);
            pstm.setInt(1, studentId);
            ResultSet resultSet1 = exQuery();
            if (resultSet1.next()) {
                String studentName = resultSet1.getString(2);
                librarian.setStudent_name(studentName);
            }

            list.add(librarian);
        }

        return list;
    }

    @Override
    public Librarian getLibrarianById(int id) throws SQLException {
        Librarian librarian = null;
        PreparedStatement pstm = openPrepareStatement(GET_LIBARIAN_BY_ID);
        pstm.setInt(1, id);
        ResultSet rs = exQuery();

        if (rs.next()) {
            librarian = new Librarian();
            librarian.setBook_id(rs.getInt(1)); // Thiết lập ID của thủ thư từ cơ sở dữ liệu
            librarian.setStudent_id(rs.getInt(2)); // Thiết lập tên của thủ thư từ cơ sở dữ liệu
            // Cập nhật các thông tin khác của thủ thư từ cơ sở dữ liệu tương tự

            System.out.println("Book id: " + rs.getInt(1));
            System.out.println("session2.Student id: " + rs.getInt(2));
        }

        return librarian;
    }

    @Override
    public void updateLibrarian(Librarian librarian) throws SQLException {
        PreparedStatement pstm = openPrepareStatement(UPDATE_LIBRARIAN);
        pstm.setInt(1,librarian.getBook_id());
        pstm.setInt(2,librarian.getStudent_id());
        pstm.setInt(3,librarian.getId());
        exUpdate();
    }

    @Override
    public boolean deleteLibrarian(int id) throws SQLException {
        return false;
    }
}
