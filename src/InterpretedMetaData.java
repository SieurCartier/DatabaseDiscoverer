import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class InterpretedMetaData {

	private Database database;
	private DatabaseMetaData databaseMetaData;
	private Connection connection;

	public InterpretedMetaData(DatabaseMetaData databaseMetaData) throws NotInitialiazedDatabaseException {
		database = Database.getInstance();
		connection = database.getConnection();
		this.databaseMetaData = databaseMetaData;
	}

	public Map<String, TableInfo> getTableInfo(String tableType[]) throws SQLException {

		Map<String, TableInfo> ret = new HashMap<String, TableInfo>();

		try (ResultSet tables = databaseMetaData.getTables(null, null, null, tableType)) {
			while (tables.next()) {
				String catalog = tables.getString("TABLE_CAT");
				String schema = tables.getString("TABLE_SCHEM");
				String name = tables.getString("TABLE_NAME");
				String rootType = tables.getString("TABLE_TYPE");
				String remarks = tables.getString("REMARKS");
				String typesCatalog = tables.getString("TYPE_CAT");
				String typesSchema = tables.getString("TYPE_SCHEM");
				String typeName = tables.getString("TYPE_NAME");
				String selfReferencingColumnName = tables.getString("SELF_REFERENCING_COL_NAME");
				String rootRefGen = tables.getString("REF_GENERATION");

				TableInfo info = new TableInfo(catalog, schema, name, rootType, remarks, typesCatalog, typesSchema,
						typeName, selfReferencingColumnName, rootRefGen);

				ret.put(info.getName(), info);
			}
		}

		return ret;
	}

	public Map<String, FieldInfo> getColumnInfo(String tableName) throws SQLException {

		Map<String, FieldInfo> ret = new HashMap<String, FieldInfo>();

		try (ResultSet columns = databaseMetaData.getColumns(null, null, tableName, null)) {
			while (columns.next()) {
				String table_cat = columns.getString("TABLE_CAT");
				String table_schem = columns.getString("TABLE_SCHEM");
				String table_name = columns.getString("TABLE_NAME");
				String column_name = columns.getString("COLUMN_NAME");
				int data_type = columns.getInt("DATA_TYPE");
				String type_name = columns.getString("TYPE_NAME");
				int column_size = columns.getInt("COLUMN_SIZE");
				Object buffer_length = columns.getString("BUFFER_LENGTH");
				Integer decimal_digits;
				try {
					decimal_digits = columns.getInt("DECIMAL_DIGITS");
				} catch (Exception e) {
					decimal_digits = null;
				}
				int num_prec_radix = columns.getInt("NUM_PREC_RADIX");
				int nullable = columns.getInt("NULLABLE");
				String remarks = columns.getString("REMARKS");
				String column_def = columns.getString("COLUMN_DEF");
				int sql_data_type = columns.getInt("SQL_DATA_TYPE");
				int sql_datetime_sub = columns.getInt("SQL_DATETIME_SUB");
				int char_octet_length = columns.getInt("CHAR_OCTET_LENGTH");
				int ordinal_position = columns.getInt("ORDINAL_POSITION");
				String is_nullable_root = columns.getString("IS_NULLABLE");
				String scope_catalog = columns.getString("SCOPE_CATALOG");
				String scope_schema = columns.getString("SCOPE_SCHEMA");
				String scope_table = columns.getString("SCOPE_TABLE");
				Short source_data_type;
				try {
					source_data_type = columns.getShort("SOURCE_DATA_TYPE");
				} catch (Exception e) {
					source_data_type = null;
				}

				String is_autoincrement_root = columns.getString("IS_AUTOINCREMENT");
				String is_generatedcolumn_root = columns.getString("IS_GENERATEDCOLUMN");

				FieldInfo info = new FieldInfo(table_cat, table_schem, table_name, column_name, data_type, type_name,
						column_size, buffer_length, decimal_digits, num_prec_radix, nullable, remarks, column_def,
						sql_data_type, sql_datetime_sub, char_octet_length, ordinal_position, is_nullable_root,
						scope_catalog, scope_schema, scope_table, source_data_type, is_autoincrement_root,
						is_generatedcolumn_root);

				ret.put(info.getColumn_name(), info);
			}
		}

		return ret;
	}

//	public Map<String, ImportedKeysInfo> getImportedKeysInfos(Table table) throws SQLException {
//
//		Map<String, ImportedKeysInfo> ret = new HashMap<String, ImportedKeysInfo>();
//
//		try (ResultSet importedKeys = databaseMetaData.getImportedKeys(null, null, table.getName())) {
//			while (tables.next()) {
//				String catalog = tables.getString("TABLE_CAT");
//				String schema = tables.getString("TABLE_SCHEM");
//				String name = tables.getString("TABLE_NAME");
//				String rootType = tables.getString("TABLE_TYPE");
//				String remarks = tables.getString("REMARKS");
//				String typesCatalog = tables.getString("TYPE_CAT");
//				String typesSchema = tables.getString("TYPE_SCHEM");
//				String typeName = tables.getString("TYPE_NAME");
//				String selfReferencingColumnName = tables.getString("SELF_REFERENCING_COL_NAME");
//				String rootRefGen = tables.getString("REF_GENERATION");
//
//				TableInfo info = new TableInfo(catalog, schema, name, rootType, remarks, typesCatalog, typesSchema,
//						typeName, selfReferencingColumnName, rootRefGen);
//
//				ret.put(info.getName(), info);
//			}
//		}
//
//		return ret;
//	}

	@Override
	public String toString() {
		return "InterpretedMetaData [database=" + database + ", databaseMetaData=" + databaseMetaData + ", connection="
				+ connection + "]";
	}

}
