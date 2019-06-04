package infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

	private Database() {}

	private static Connection conexao = null;

	public static Connection getConnection() {
		if (conexao == null) {
			try {
				Properties propriedades = carregaPropriedades();
				String url = propriedades.getProperty("dburl");
				conexao = DriverManager.getConnection(url, propriedades);
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return conexao;
	}

	private static Properties carregaPropriedades() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);                                               
			return props;
		}catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
