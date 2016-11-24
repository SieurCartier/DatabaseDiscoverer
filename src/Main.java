import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {

		Database db = Database.getInstance();
		db.init(null, "jdbc:mysql://localhost/testdb?", "root", null);

		InterpretedMetaData im = db.getInterpretedMetaData();
		String tableType[] = { "TABLE" };
		Map<String, TableInfo> m = im.getTableInfo(tableType);
		System.out.println(im.getTableInfo(tableType));

		TableFabric ft = TableFabric.getInstance();
		FieldFabric ff = FieldFabric.getInstance();

		for (TableInfo t : m.values()) {
			Table temp = ft.createTable(t);
			Map<String, FieldInfo> mfi = im.getColumnInfo(temp.getName());
			for (FieldInfo fi : mfi.values()) {
				Field f = ff.createField(fi);
				temp.addField(f);
				System.out.println(f);
			}
			System.out.println(temp);
		}

		return;
	}

}
