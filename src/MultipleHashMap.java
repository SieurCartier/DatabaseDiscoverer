import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MultipleHashMap<K, V> {

	private Map<K, List<V>> values = new HashMap<>();

	public MultipleHashMap() {
		super();
	}

	public MultipleHashMap(Map<K, List<V>> values) {
		super();
		this.values = values;
	}

	public Map<K, List<V>> getValues() {
		return values;
	}

	public List<V> get(K key) {
		return values.get(key);
	}

	public void setValues(Map<K, List<V>> values) {
		this.values = values;
	}

	public void put(K key, V value) {
		if (!values.containsKey(key)) {
			values.put(key, new LinkedList<V>());
		}
		values.get(key).add(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultipleHashMap other = (MultipleHashMap) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MultipleHashMap [values=" + values + "]";
	}

}
