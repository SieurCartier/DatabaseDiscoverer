import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Table extends IdentifiedItem {

	private String name;
	private Map<String, Field> fields = null;
	private Field primaryKey = null;
	private MultipleHashMap<Field, Field> foreignKeys = null;

	protected Table(String name, Map<String, Field> fields, Field primaryKey,
			MultipleHashMap<Field, Field> foreignKeys) {
		super(name);
		this.name = name;
		this.fields = fields;
		this.primaryKey = primaryKey;
		this.foreignKeys = foreignKeys;
	}

	public Table(String name) {
		super(name);
		this.name = name;
	}

	public Table(TableBuilder builder) {
		super(builder.name);
		name = builder.getName();
	}

	public String getName() {
		return name;
	}

	public Map<String, Field> getFields() {
		if (fields == null)
			FieldFabric.getInstance().getFields(this);
		return fields;
	}

	public Field getField(String name) {
		return fields.get(name);
	}

	public void setFields(Map<String, Field> fields) {
		this.fields = fields;
	}

	public void addField(Field field) {
		fields.put(field.getName(), field);
	}

	public Field getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Field primaryKey) {
		this.primaryKey = primaryKey;
	}

	public MultipleHashMap<Field, Field> getForeignKeys() {
		return foreignKeys;
	}

	public List<Field> getReferencedFields(Field field) {
		return foreignKeys.get(field);
	}

	public void setForeignKeys(MultipleHashMap<Field, Field> foreignKeys) {
		this.foreignKeys = foreignKeys;
	}

	public void addForeignKey(Field key, Field references) {
		foreignKeys.put(key, references);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((foreignKeys == null) ? 0 : foreignKeys.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((primaryKey == null) ? 0 : primaryKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (foreignKeys == null) {
			if (other.foreignKeys != null)
				return false;
		} else if (!foreignKeys.equals(other.foreignKeys))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (primaryKey == null) {
			if (other.primaryKey != null)
				return false;
		} else if (!primaryKey.equals(other.primaryKey))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Table [name=" + name + ", fields=" + fields + ", primaryKey=" + primaryKey + ", foreignKeys="
				+ foreignKeys + "]";
	}

	public static class TableBuilder extends Builder<Table> {

		private TableInfo infos;
		private String name;

		public TableBuilder(TableInfo infos) throws SQLException {
			this.infos = infos;
			processInfos();
		}

		private void processInfos() throws SQLException {
			name = processName();
		}

		private String processName() throws SQLException {
			return infos.getName();
		}

		public String getName() {
			return name;
		}

		@Override
		public Table build() {
			return new Table(this);
		}

	}

}
