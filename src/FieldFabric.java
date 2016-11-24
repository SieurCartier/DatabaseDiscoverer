import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FieldFabric extends AbstractFabric<Field, Field.FieldBuilder> {

	private static FieldFabric singleton;

	private FieldFabric() {
		super();
	}

	public static FieldFabric getInstance() {
		if (singleton == null)
			singleton = new FieldFabric();
		return singleton;
	}

	public Field createField(FieldInfo info) throws SQLException {
		return createItem(new Field.FieldBuilder(info));
	}

	public List<Field> getFields(Table table) {
		return getFields(table.getName());
	}

	public List<Field> getFields(String tableName) {
		List<Field> ret = new LinkedList<Field>();

		for (String s : items.keySet()) {
			if (s.startsWith(tableName + "."))
				ret.add(items.get(s));
		}

		return ret;
	}

}
