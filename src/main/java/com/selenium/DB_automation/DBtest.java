package com.selenium.DB_automation;

import com.selenium.base.BaseClass;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBtest extends BaseClass {
    @Test
    public void DBtestSelectQuery() throws SQLException {
        con=this.setup();
        Statement stm=con.createStatement();
        ResultSet result=stm.executeQuery("select*from studentDetails");
        while (result.next()){
            int studID=result.getInt(1);
            String studName=result.getString(2);
            String qualification=result.getString(3);
            System.out.println(studID+" "+studName+"  "+qualification);
        }
    }
    @Test
    public void DBtestInsertData() throws SQLException {
        con=this.setup();
        PreparedStatement ps=con.prepareStatement("insert into studentDetails values(?,?,?)");
        ps.setInt(1,102);
        //ps.setInt();
        ps.setString(2,"dash");
        ps.setString(3,"B.tech");

        ps.executeUpdate();
        DBtestSelectQuery();
    }
    @Test
    public void DBtestDeleteData() throws SQLException {
        con=this.setup();
        PreparedStatement ps=con.prepareStatement("delete from studentDetails where studID=102");
        ps.executeUpdate();
        DBtestSelectQuery();
    }
    @Test
    public void DBtestUpdateData() throws SQLException {
        con=this.setup();
        PreparedStatement ps=con.prepareStatement("update studentDetails set qualification='MBA' where studID=102");
        ps.executeUpdate();
        DBtestSelectQuery();
    }
}
