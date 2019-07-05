package com.ibm.gbs.asset.profileassistant.test;

import com.ibm.gbs.asset.profileassistant.test.aop.LogExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
@Component
public class ExampleDAO {

    private Logger logger = LoggerFactory.getLogger(ExampleDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testConnection(){

        logger.info("Test JDBC connection");
        jdbcTemplate.query("SELECT first_name, last_name, department, email FROM ProfileAssistant.employees;",
                (rs, rowNum) -> new Employee(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("department"),
                        rs.getString("email")
                )
        ).forEach(employee -> logger.info(employee.toString()));

    }

    @LogExecution
    public List<Employee> getDeptEmployee(String dept){
        String sql = "SELECT first_name, last_name, department, email FROM ProfileAssistant.employees where department = ?";
        List<Employee> deptEmploees = jdbcTemplate.query(sql, (pstmt) -> pstmt.setString(1, dept) , (rs, rowNum) -> new Employee(
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("department"),
                rs.getString("email")
        ));
        return deptEmploees;


    }
}
