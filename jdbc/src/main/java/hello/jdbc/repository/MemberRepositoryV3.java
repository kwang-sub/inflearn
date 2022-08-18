package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
public class MemberRepositoryV3 {

    private final DataSource dataSource;


    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate();
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(conn, pstmt, null);
        }

    }

    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id = ?";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            int i = pstmt.executeUpdate();
            log.info("delete = {}", i);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(conn, pstmt, rs);
        }
    }

    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else {
                throw new NoSuchElementException("member not found memberId = " + memberId);
            }

        } catch (SQLException e) {
            log.error("sql error", e);
            throw e;
        } finally {
            close(conn, pstmt, rs);
        }
    }

    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money = ? where member_id = ?";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId);
            int i = pstmt.executeUpdate();
            log.info("result = {} ", i);
        } catch (SQLException e) {
            throw e;
        } finally {
            close(conn, pstmt, null);
        }
    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        DataSourceUtils.releaseConnection(conn, dataSource);
    }

    private Connection getConnection() throws SQLException {
        Connection con = DataSourceUtils.getConnection(dataSource);
        log.info("get Connection = {}, class = {}", con, con.getClass());
        return con;
    }
}
