import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFabric<T extends IdentifiedItem, B extends Builder<T>> {

	protected Map<String, T> items = new HashMap<>();

	protected T createItem(B builder) {
		T ret = builder.build();
		items.put(ret.getIdentifier(), ret);
		return ret;
	}

	protected T getItem(String identifier) {
		T ret = items.get(identifier);
		return ret;
	}

	

}
