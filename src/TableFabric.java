import java.sql.SQLException;

public class TableFabric extends AbstractFabric<Table, Table.TableBuilder> {
	private static TableFabric singleton;

	private TableFabric() {

	}

	public static TableFabric getInstance() {
		if (singleton == null)
			singleton = new TableFabric();
		return singleton;
	}

	public Table createTable(TableInfo info) throws SQLException {
		return createItem(new Table.TableBuilder(info));
	}

}
