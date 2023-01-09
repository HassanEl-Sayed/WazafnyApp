package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.jdbc.OracleDriver;

public class new2 {
    private RichInputText it3;
    private RichCommandButton cb2;
    private RichInputText it2;
    private RichInputText it1;
    private RichForm f1;
    private RichDocument d1;

    public new2() {
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }
    
    
    public String loggin_action() {
    String u = it1.getValue().toString();
    String p = it2.getValue().toString();
    boolean b= chkUser(u,p);
    if(b){
    JSFUtils.storeOnSession("email",u);
    JSFUtils.storeOnSession("pass",p);

          return "Users.jsf";
    }else{
          
        it3.setValue("Invalid User");
        return  "untitled4.jsf";
    }
    
    }
         

    
    public static boolean chkUser(String u ,String p) {
    Connection con;
    boolean b=false;
    String sql="Select * from Users where user_email=? and user_password=?";
    try {
        con = getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, u);
        st.setString(2, p);
        ResultSet rs = st.executeQuery();
        if(rs.next())
             b=true;
        
    } catch (SQLException e) {
        //System.out.println("error");
    }
    return b;
    }
    
    public static Connection getConnection() throws SQLException {
    String username = "wazafny1";
    String password = "wazafny1";
    String thinConn = "jdbc:oracle:thin:@localhost:1521:ORC";
    DriverManager.registerDriver(new OracleDriver());
    Connection conn = DriverManager.getConnection(thinConn, username, password);
    conn.setAutoCommit(true);
    return conn;
    }


    
  
}
