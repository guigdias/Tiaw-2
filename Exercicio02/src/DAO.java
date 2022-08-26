import java.sql.*;

public class DAO {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;

	
	DAO(){
		url = "jdbc:postgresql://localhost:5432/postgres";
		usuario = "ti2cc";
		senha = "ti@cc";
	
	try {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, usuario, senha);
		System.out.println("Conexão realizada com sucesso");
	}	
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	public int executaSQL(String sql)
	{
		try {
			java.sql.Statement stm = con.createStatement();
			int res = stm.executeUpdate(sql);
			con.close();
			return res;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public ResultSet executaBusca(String sql)
	{
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}