package dao.impl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mapper.LoanMapper;
import model.LoanModel;

/**
 *
 * @author ACER
 */
public class LoanDao extends AbstractDAO<LoanModel> {

    @Override
    public java.sql.Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bankingxyz";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public List<LoanModel> SelectAllLoanModel(String customerId) {
        String sql = "Select * from loan JOIN customer_loan ON loan.loan_number=customer_loan.loan_number where customer_id = ?";
        return query(sql, new LoanMapper(), customerId);
    }

    public Long save(LoanModel loanModel, String customerId) {
        Random random = new Random();

        int min = 1000;
        int max = 10000;
        int randomNumber;

        String sqlLoanNumber = "SELECT loan_number, loan_amount, branch_id FROM loan;";
        List<LoanModel> listLoanNumber = query(sqlLoanNumber, new LoanMapper());

        Set<Integer> existingLoanNumbers = new HashSet<>();
        for (LoanModel existingLoan : listLoanNumber) {
            existingLoanNumbers.add(existingLoan.getLoanNumber());
        }

        do {
            randomNumber = random.nextInt(max - min + 1) + min;
        } while (existingLoanNumbers.contains(randomNumber));

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO loan (loan_number, loan_amount, branch_id) ");
        sql.append("VALUES (?, ?, ?);");
        Long generatedId = insert(sql.toString(), randomNumber, loanModel.getLoanAmount(), loanModel.getBranch_id());

        StringBuilder sql1 = new StringBuilder();
        sql1.append("INSERT INTO customer_loan (customer_id, loan_number) VALUES (?,?);");
        insert(sql1.toString(), customerId, randomNumber);

        return generatedId;
    }

}
