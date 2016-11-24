import java.sql.JDBCType;

public class FieldInfo {

	private String table_cat;
	private String table_schem;
	private String table_name;
	private String column_name;
	private int data_type;
	private JDBCType type;
	private String type_name;
	private int column_size;
	private Object buffer_length;
	private Integer decimal_digits;
	private int num_prec_radix;
	private int nullable;
	private String remarks;
	private String column_def;
	private int sql_data_type;
	private int sql_datetime_sub;
	private int char_octet_length;
	private int ordinal_position;
	private String is_nullable_root;
	private Boolean is_nullable;
	private String scope_catalog;
	private String scope_schema;
	private String scope_table;
	private Short source_data_type;
	private String is_autoincrement_root;
	private Boolean is_autoincrement;
	private String is_generatedcolumn_root;
	private Boolean is_generatedcolumn;

	public FieldInfo(String table_name, String column_name) {
		super();

	}

	public FieldInfo(String table_cat, String table_schem, String table_name, String column_name, int data_type,
			String type_name, int column_size, Object buffer_length, Integer decimal_digits, int num_prec_radix,
			int nullable, String remarks, String column_def, int sql_data_type, int sql_datetime_sub,
			int char_octet_length, int ordinal_position, String is_nullable_root, String scope_catalog,
			String scope_schema, String scope_table, Short source_data_type, String is_autoincrement_root,
			String is_generatedcolumn_root) {
		super();
		this.table_cat = table_cat;
		this.table_schem = table_schem;
		this.table_name = table_name;
		this.column_name = column_name;
		this.data_type = data_type;
		this.type_name = type_name;
		this.column_size = column_size;
		this.buffer_length = buffer_length;
		this.decimal_digits = decimal_digits;
		this.num_prec_radix = num_prec_radix;
		this.nullable = nullable;
		this.remarks = remarks;
		this.column_def = column_def;
		this.sql_data_type = sql_data_type;
		this.sql_datetime_sub = sql_datetime_sub;
		this.char_octet_length = char_octet_length;
		this.ordinal_position = ordinal_position;
		this.is_nullable_root = is_nullable_root;
		this.scope_catalog = scope_catalog;
		this.scope_schema = scope_schema;
		this.scope_table = scope_table;
		this.source_data_type = source_data_type;
		this.is_autoincrement_root = is_autoincrement_root;
		this.is_generatedcolumn_root = is_generatedcolumn_root;
	}

	public String getTable_cat() {
		return table_cat;
	}

	public String getTable_schem() {
		return table_schem;
	}

	public String getTable_name() {
		return table_name;
	}

	public String getColumn_name() {
		return column_name;
	}

	public int getData_type() {
		return data_type;
	}

	public JDBCType getType() {
		if (type == null)
			type = JDBCType.valueOf(data_type);
		return type;
	}

	public String getType_name() {
		return type_name;
	}

	public int getColumn_size() {
		return column_size;
	}

	public Object getBuffer_length() {
		return buffer_length;
	}

	public Integer getDecimal_digits() {
		return decimal_digits;
	}

	public int getNum_prec_radix() {
		return num_prec_radix;
	}

	public int getNullable() {
		return nullable;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getColumn_def() {
		return column_def;
	}

	public int getSql_data_type() {
		return sql_data_type;
	}

	public int getSql_datetime_sub() {
		return sql_datetime_sub;
	}

	public int getChar_octet_length() {
		return char_octet_length;
	}

	public int getOrdinal_position() {
		return ordinal_position;
	}

	public String getIs_nullable_root() {
		return is_nullable_root;
	}

	public Boolean getIs_nullable() {
		if (!is_nullable_root.equals("") && is_nullable == null)
			is_nullable = is_nullable_root.equals("YES");

		return is_nullable;
	}

	public String getScope_catalog() {
		return scope_catalog;
	}

	public String getScope_schema() {
		return scope_schema;
	}

	public String getScope_table() {
		return scope_table;
	}

	public Short getSource_data_type() {
		return source_data_type;
	}

	public String getIs_autoincrement_root() {
		return is_autoincrement_root;
	}

	public Boolean getIs_autoincrement() {
		if (!is_autoincrement_root.equals("") && is_autoincrement == null)
			is_autoincrement = is_autoincrement_root.equals("YES");

		return is_autoincrement;
	}

	public String getIs_generatedcolumn_root() {
		return is_generatedcolumn_root;
	}

	public Boolean getIs_generatedcolumn() {
		if (!is_generatedcolumn_root.equals("") && is_generatedcolumn == null)
			is_generatedcolumn = is_generatedcolumn_root.equals("YES");

		return is_generatedcolumn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buffer_length == null) ? 0 : buffer_length.hashCode());
		result = prime * result + char_octet_length;
		result = prime * result + ((column_def == null) ? 0 : column_def.hashCode());
		result = prime * result + ((column_name == null) ? 0 : column_name.hashCode());
		result = prime * result + column_size;
		result = prime * result + data_type;
		result = prime * result + ((decimal_digits == null) ? 0 : decimal_digits.hashCode());
		result = prime * result + ((is_autoincrement == null) ? 0 : is_autoincrement.hashCode());
		result = prime * result + ((is_autoincrement_root == null) ? 0 : is_autoincrement_root.hashCode());
		result = prime * result + ((is_generatedcolumn == null) ? 0 : is_generatedcolumn.hashCode());
		result = prime * result + ((is_generatedcolumn_root == null) ? 0 : is_generatedcolumn_root.hashCode());
		result = prime * result + ((is_nullable == null) ? 0 : is_nullable.hashCode());
		result = prime * result + ((is_nullable_root == null) ? 0 : is_nullable_root.hashCode());
		result = prime * result + nullable;
		result = prime * result + num_prec_radix;
		result = prime * result + ordinal_position;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((scope_catalog == null) ? 0 : scope_catalog.hashCode());
		result = prime * result + ((scope_schema == null) ? 0 : scope_schema.hashCode());
		result = prime * result + ((scope_table == null) ? 0 : scope_table.hashCode());
		result = prime * result + ((source_data_type == null) ? 0 : source_data_type.hashCode());
		result = prime * result + sql_data_type;
		result = prime * result + sql_datetime_sub;
		result = prime * result + ((table_cat == null) ? 0 : table_cat.hashCode());
		result = prime * result + ((table_name == null) ? 0 : table_name.hashCode());
		result = prime * result + ((table_schem == null) ? 0 : table_schem.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((type_name == null) ? 0 : type_name.hashCode());
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
		FieldInfo other = (FieldInfo) obj;
		if (buffer_length == null) {
			if (other.buffer_length != null)
				return false;
		} else if (!buffer_length.equals(other.buffer_length))
			return false;
		if (char_octet_length != other.char_octet_length)
			return false;
		if (column_def == null) {
			if (other.column_def != null)
				return false;
		} else if (!column_def.equals(other.column_def))
			return false;
		if (column_name == null) {
			if (other.column_name != null)
				return false;
		} else if (!column_name.equals(other.column_name))
			return false;
		if (column_size != other.column_size)
			return false;
		if (data_type != other.data_type)
			return false;
		if (decimal_digits == null) {
			if (other.decimal_digits != null)
				return false;
		} else if (!decimal_digits.equals(other.decimal_digits))
			return false;
		if (is_autoincrement == null) {
			if (other.is_autoincrement != null)
				return false;
		} else if (!is_autoincrement.equals(other.is_autoincrement))
			return false;
		if (is_autoincrement_root == null) {
			if (other.is_autoincrement_root != null)
				return false;
		} else if (!is_autoincrement_root.equals(other.is_autoincrement_root))
			return false;
		if (is_generatedcolumn == null) {
			if (other.is_generatedcolumn != null)
				return false;
		} else if (!is_generatedcolumn.equals(other.is_generatedcolumn))
			return false;
		if (is_generatedcolumn_root == null) {
			if (other.is_generatedcolumn_root != null)
				return false;
		} else if (!is_generatedcolumn_root.equals(other.is_generatedcolumn_root))
			return false;
		if (is_nullable == null) {
			if (other.is_nullable != null)
				return false;
		} else if (!is_nullable.equals(other.is_nullable))
			return false;
		if (is_nullable_root == null) {
			if (other.is_nullable_root != null)
				return false;
		} else if (!is_nullable_root.equals(other.is_nullable_root))
			return false;
		if (nullable != other.nullable)
			return false;
		if (num_prec_radix != other.num_prec_radix)
			return false;
		if (ordinal_position != other.ordinal_position)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (scope_catalog == null) {
			if (other.scope_catalog != null)
				return false;
		} else if (!scope_catalog.equals(other.scope_catalog))
			return false;
		if (scope_schema == null) {
			if (other.scope_schema != null)
				return false;
		} else if (!scope_schema.equals(other.scope_schema))
			return false;
		if (scope_table == null) {
			if (other.scope_table != null)
				return false;
		} else if (!scope_table.equals(other.scope_table))
			return false;
		if (source_data_type == null) {
			if (other.source_data_type != null)
				return false;
		} else if (!source_data_type.equals(other.source_data_type))
			return false;
		if (sql_data_type != other.sql_data_type)
			return false;
		if (sql_datetime_sub != other.sql_datetime_sub)
			return false;
		if (table_cat == null) {
			if (other.table_cat != null)
				return false;
		} else if (!table_cat.equals(other.table_cat))
			return false;
		if (table_name == null) {
			if (other.table_name != null)
				return false;
		} else if (!table_name.equals(other.table_name))
			return false;
		if (table_schem == null) {
			if (other.table_schem != null)
				return false;
		} else if (!table_schem.equals(other.table_schem))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (type_name == null) {
			if (other.type_name != null)
				return false;
		} else if (!type_name.equals(other.type_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColumnInfo [table_cat=" + table_cat + ", table_schem=" + table_schem + ", table_name=" + table_name
				+ ", column_name=" + column_name + ", data_type=" + data_type + ", type=" + getType() + ", type_name="
				+ type_name + ", column_size=" + column_size + ", buffer_length=" + buffer_length + ", decimal_digits="
				+ decimal_digits + ", num_prec_radix=" + num_prec_radix + ", nullable=" + nullable + ", remarks="
				+ remarks + ", column_def=" + column_def + ", sql_data_type=" + sql_data_type + ", sql_datetime_sub="
				+ sql_datetime_sub + ", char_octet_length=" + char_octet_length + ", ordinal_position="
				+ ordinal_position + ", is_nullable_root=" + is_nullable_root + ", is_nullable=" + getIs_nullable()
				+ ", scope_catalog=" + scope_catalog + ", scope_schema=" + scope_schema + ", scope_table=" + scope_table
				+ ", source_data_type=" + source_data_type + ", is_autoincrement_root=" + is_autoincrement_root
				+ ", is_autoincrement=" + getIs_autoincrement() + ", is_generatedcolumn_root=" + is_generatedcolumn_root
				+ ", is_generatedcolumn=" + getIs_generatedcolumn() + "]";
	}

}
