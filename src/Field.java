import java.sql.JDBCType;

public class Field extends IdentifiedItem {

	private Table parentTable;
	private String name;
	private JDBCType type;
	private int size;
	private Boolean nullable;

	public Field(Table parentTable, String name, JDBCType type, int size, Boolean nullable) {
		super(parentTable.getName() + "." + name);
		this.parentTable = parentTable;
		this.name = name;
		this.type = type;
		this.size = size;
		this.nullable = nullable;
	}

	public Field(FieldBuilder fieldBuilder) {
		super(fieldBuilder.getParentTable().getName() + "." + fieldBuilder.getName());
		this.parentTable = fieldBuilder.getParentTable();
		this.name = fieldBuilder.getName();
		this.type = fieldBuilder.getType();
		this.size = fieldBuilder.getSize();
		this.nullable = fieldBuilder.getNullable();
	}

	public Table getParentTable() {
		return parentTable;
	}

	public void setParentTable(Table parentTable) {
		this.parentTable = parentTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JDBCType getType() {
		return type;
	}

	public void setType(JDBCType type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Boolean getNullable() {
		return nullable;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nullable == null) ? 0 : nullable.hashCode());
		result = prime * result + size;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Field other = (Field) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nullable != other.nullable)
			return false;
		if (size != other.size)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", type=" + type + ", size=" + size + ", nullable=" + nullable + "]";
	}

	public static class FieldBuilder extends Builder<Field> {

		private FieldInfo infos;

		private Table parentTable;
		private String name;
		private JDBCType type;
		private int size;
		private Boolean nullable;

		protected FieldBuilder(FieldInfo infos) {
			this.infos = infos;
			processInfos();
		}

		private void processInfos() {
			parentTable = processTable();
			name = processName();
			type = processType();
			size = processSize();
			nullable = processNullable();
		}

		private Boolean processNullable() {
			return infos.getIs_nullable();
		}

		private int processSize() {
			return infos.getColumn_size();
		}

		private JDBCType processType() {
			return infos.getType();
		}

		private String processName() {
			return infos.getColumn_name();
		}

		private Table processTable() {
			TableFabric fab = TableFabric.getInstance();
			return fab.getItem(infos.getTable_name());
		}

		public String getName() {
			return name;
		}

		public FieldInfo getInfos() {
			return infos;
		}

		public Table getParentTable() {
			return parentTable;
		}

		public JDBCType getType() {
			return type;
		}

		public int getSize() {
			return size;
		}

		public Boolean getNullable() {
			return nullable;
		}

		@Override
		public Field build() {
			return new Field(this);
		}
	}

}
