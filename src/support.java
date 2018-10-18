
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wijaya
 */
public class support {
  private static  Connection kon ;
  private static Connection open(){
      try{
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      kon= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_crud1", "root", "");
      }catch(SQLException ex){
      System.out.println(ex.toString());
      }
      return kon;
  }
  
  public static ResultSet setResult(String tabel, String attribute, String param){
  ResultSet res=null;
  try{
      open();
      Statement stm=kon.createStatement();
      res=stm.executeQuery("Select "+attribute+" from "+tabel+" "+param+"");
  }catch(SQLException ex){
  System.out.println(ex.toString());
  }
  return res;}
public static Boolean queryInsert(String table, String column, String values){
Boolean res=false;
try{
    open();
    Statement stm =kon.createStatement();
    stm.execute("insert into "+table +" "+column+" values "+values);
    res=true;
}catch(SQLException ex){
System.out.print("err "+ex.toString());
}return res;}

public static Boolean queryUpdate(String table, String fieldValue, String param){
Boolean res=false;
try{
open();
Statement stm= kon.createStatement();
stm.execute("update "+table+" set "+fieldValue+" "+param);
res=true;
}catch(SQLException ex){
System.out.println(ex.toString());
}return res;}

public static Boolean queryDelete(String table, String param){
Boolean res=false;
try{
    Statement stm= kon.createStatement();
    stm.execute("update "+table+" "+param+" ");
    res=true;
}catch(SQLException ex){
System.out.println(ex.toString());
}return res;}
}

