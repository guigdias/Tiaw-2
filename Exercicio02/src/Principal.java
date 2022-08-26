import java.sql.*;
import java.util.*;
public class Principal {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO con = new DAO();
		int VAL = 1000;
		for(int i = 0; i < VAL; i++) 
		{		
			int op;
			System.out.println("1- Insert \n2- Select\n3- Update\n4- Delete\n5- Sair");
			System.out.print("Enter op : ");
			op = sc.nextInt();
			if(op == 1)
			{
				String sql = "INSERT into cliente (id, nome, email)" + " VALUES (default, 'Andre', 'Andre@gmail.com')";
				int res = con.executaSQL(sql);
				if(res > 0)
				{
					System.out.println("Usuario Cadastrado");
				}
				else
				{
					System.out.println("Usuario nao foi Cadastrado");
				}		
			}

			if(op == 2)
			{
				String sql2 = "SELECT * FROM cliente";
				ResultSet rs = con.executaBusca(sql2);
				try 
				{
					while(rs.next())
					{
               	    	int id = rs.getInt("id");
						String nome = rs.getString("nome");
						String email = rs.getString("email");
						System.out.println(id+" - "+nome+" - "+email);
            		}
				} 	
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}

			if(op == 3)
			{
				
			}
			if(op == 4)
			{

			}
			if(op == 5)
			{
				break;
			}

		}
		sc.close();
	
	

}
}
