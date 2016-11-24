import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private Connection connection;
	private DatabaseMetaData databaseMetaData;
	private InterpretedMetaData interpretedMetaData;
	private DatabaseType databaseType;
	private String user;
	private String password;
	private String URL;
	private boolean initialized = false;

	private static Database singleton;

	private Database() {

	}

	public static Database getInstance() {
		if (singleton == null)
			singleton = new Database();
		return singleton;
	}

	public Connection getConnection() throws NotInitialiazedDatabaseException {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(URL, user, password);
			} catch (SQLException ex) {
				if (!initialized)
					throw new NotInitialiazedDatabaseException();

				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
		return connection;
	}

	public void init(DatabaseType databaseType, String URL, String user, String password) {
		this.databaseType = databaseType;
		this.user = user;
		this.password = password;
		this.URL = URL;
		initialized = true;
	}

	public DatabaseMetaData getDatabaseMetaData() throws SQLException, NotInitialiazedDatabaseException {
		if (databaseMetaData == null)
			databaseMetaData = getConnection().getMetaData();
		return databaseMetaData;
	}

	public InterpretedMetaData getInterpretedMetaData() throws SQLException, NotInitialiazedDatabaseException {
		if (interpretedMetaData == null)
			interpretedMetaData = new InterpretedMetaData(getDatabaseMetaData());
		return interpretedMetaData;
	}

	public DatabaseType getDatabaseType() {
		return databaseType;
	}

}
