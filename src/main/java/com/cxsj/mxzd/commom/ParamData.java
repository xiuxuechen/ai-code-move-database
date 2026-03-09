package com.cxsj.mxzd.commom;


import org.apache.commons.lang.StringUtils;

import jakarta.servlet.http.HttpServletRequest;
import java.util.*;


@SuppressWarnings("rawtypes")
public class ParamData extends HashMap implements Map {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8092201321058677627L;

	private transient Map<Object, Object> map;

	private HttpServletRequest request;

	public ParamData() {
		map = new HashMap<>(30);
	}

	public ParamData(HttpServletRequest request) {
		this.request = request;
	}

	public void init() {
		Map<String, String[]> properties = request.getParameterMap();
		Map<Object, Object> returnMap = new HashMap<>(20);
		Iterator entries = properties.entrySet().iterator();
		Entry entry;
		String name;
		String value = "";
		while (entries.hasNext()) {
			entry = (Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				if (StringUtils.isNotBlank(value)) {
					value = value.substring(0, value.length() - 1);
				}
			} else {
				value = valueObj.toString();
			}
			if (StringUtils.isNotBlank(value))
				returnMap.put(name, replaceSpecialCharacters(value));
		}
		if (returnMap.containsKey(Constants.CUR_PAGE) && returnMap.containsKey(Constants.PAGE_SIZE)) {
			returnMap.put(Constants.LIMIT_FROM,
					getLimitFrom(returnMap.get(Constants.CUR_PAGE), returnMap.get(Constants.PAGE_SIZE)));
			returnMap.put(Constants.LIMIT_TO, getLimitTo(returnMap.get(Constants.PAGE_SIZE)));
		} else {
			returnMap.put(Constants.LIMIT_FROM, Constants.DEFAULT_LIMIT_FROM);
			returnMap.put(Constants.LIMIT_TO, Constants.DEFAULT_LIMIT_TO);
		}
		map = returnMap;
	}

	@Override
	public Object get(Object key) {
		Object obj;
		if (map.get(key) instanceof Object[]) {
			Object[] arr = (Object[]) map.get(key);
			obj = request == null ? arr : (request.getParameter((String) key) == null ? arr : arr[0]);
		} else {
			obj = map.get(key);
		}
		return obj;
	}

	public String getString(Object key) {
		return (String) get(key);
	}

	@Override
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void clear() {

		map.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public Set entrySet() {
		return map.entrySet();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Set keySet() {
		return map.keySet();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void putAll(Map t) {
		map.putAll(t);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Collection values() {
		return map.values();
	}

	private int getLimitFrom(Object cruPage, Object pageSize) {
		return (Integer.valueOf(cruPage.toString()) - 1) * Integer.valueOf(pageSize.toString());
	}

	private int getLimitTo(Object pageSize) {
		return Integer.valueOf(pageSize.toString());
	}

	private String replaceSpecialCharacters(String value) {
		if (value.contains("_")) {
			return value.replace("_", "|_");
		} else if (value.contains("%")) {
			return value.replace("%", "|%");
		}
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParamData other = (ParamData) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		return true;
	}

}
