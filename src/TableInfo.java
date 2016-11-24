
public class TableInfo {

	private String catalog;
	private String schema;
	private String name;
	private String rootType;
	private TableType type;
	private String remarks;
	private String typesCatalog;
	private String typesSchema;
	private String typeName;
	private String selfReferencingColumnName;
	private String rootRefGen;
	private ReferenceGeneration referenceGeneration;

	public TableInfo(String catalog, String schema, String name, String rootType, String remarks, String typesCatalog,
			String typesSchema, String typeName, String selfReferencingColumnName, String rootRefGen) {
		super();
		this.catalog = catalog;
		this.schema = schema;
		this.name = name;
		this.rootType = rootType;
		this.remarks = remarks;
		this.typesCatalog = typesCatalog;
		this.typesSchema = typesSchema;
		this.typeName = typeName;
		this.selfReferencingColumnName = selfReferencingColumnName;
		this.rootRefGen = rootRefGen;
	}

	public String getCatalog() {
		return catalog;
	}

	public String getSchema() {
		return schema;
	}

	public String getName() {
		return name;
	}

	public String getRootType() {
		return rootType;
	}

	public TableType getType() {
		if (type == null) {
			try {
				type = TableType.valueOf(rootType.replace(' ', '_'));
			} catch (Exception e) {
				type = null;
			}
		}
		return type;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getTypesCatalog() {
		return typesCatalog;
	}

	public String getTypesSchema() {
		return typesSchema;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getSelfReferencingColumnName() {
		return selfReferencingColumnName;
	}

	public String getRootRefGen() {
		return rootRefGen;
	}

	public ReferenceGeneration getReferenceGeneration() {
		if (referenceGeneration == null) {
			try {
				referenceGeneration = ReferenceGeneration.valueOf(rootRefGen);
			} catch (Exception e) {
				referenceGeneration = null;
			}
		}
		return referenceGeneration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((referenceGeneration == null) ? 0 : referenceGeneration.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((rootRefGen == null) ? 0 : rootRefGen.hashCode());
		result = prime * result + ((rootType == null) ? 0 : rootType.hashCode());
		result = prime * result + ((schema == null) ? 0 : schema.hashCode());
		result = prime * result + ((selfReferencingColumnName == null) ? 0 : selfReferencingColumnName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
		result = prime * result + ((typesCatalog == null) ? 0 : typesCatalog.hashCode());
		result = prime * result + ((typesSchema == null) ? 0 : typesSchema.hashCode());
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
		TableInfo other = (TableInfo) obj;
		if (catalog == null) {
			if (other.catalog != null)
				return false;
		} else if (!catalog.equals(other.catalog))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (referenceGeneration != other.referenceGeneration)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (rootRefGen == null) {
			if (other.rootRefGen != null)
				return false;
		} else if (!rootRefGen.equals(other.rootRefGen))
			return false;
		if (rootType == null) {
			if (other.rootType != null)
				return false;
		} else if (!rootType.equals(other.rootType))
			return false;
		if (schema == null) {
			if (other.schema != null)
				return false;
		} else if (!schema.equals(other.schema))
			return false;
		if (selfReferencingColumnName == null) {
			if (other.selfReferencingColumnName != null)
				return false;
		} else if (!selfReferencingColumnName.equals(other.selfReferencingColumnName))
			return false;
		if (type != other.type)
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		if (typesCatalog == null) {
			if (other.typesCatalog != null)
				return false;
		} else if (!typesCatalog.equals(other.typesCatalog))
			return false;
		if (typesSchema == null) {
			if (other.typesSchema != null)
				return false;
		} else if (!typesSchema.equals(other.typesSchema))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TableInfo [catalog=" + catalog + ", schema=" + schema + ", name=" + name + ", rootType=" + rootType
				+ ", type=" + getType() + ", remarks=" + remarks + ", typesCatalog=" + typesCatalog + ", typesSchema="
				+ typesSchema + ", typeName=" + typeName + ", selfReferencingColumnName=" + selfReferencingColumnName
				+ ", rootRefGen=" + rootRefGen + ", referenceGeneration=" + getReferenceGeneration() + "]";
	}

}
