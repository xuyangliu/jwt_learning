package com.peanut.jwt_learning.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
public class SearchUtil extends HashMap<String, Object> {

    public SearchUtil() {
    }

    public static SearchUtil instance() {
        return new SearchUtil();
    }

    public static SearchUtil instance(Map<String, Object> params) {
        SearchUtil search = new SearchUtil();
        Map<String, Object> map = params.entrySet().stream().collect(Collectors.toMap(Entry::getKey, (entry) -> {
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        try {
                            return Integer.parseInt((String) value);
                        } catch (NumberFormatException exception) {
                            return value;
                        }
                    } else {
                        return value;
                    }
                }));
        search.putAll(map);
        return search;
    }

    public static SearchUtil instance(int page, int size, String sort, String direction) {
        SearchUtil search = new SearchUtil();
        search.put("page", page);
        search.put("size", size);
        search.put("sort", sort);
        search.put("direction", direction);
        return search;
    }

    public SearchUtil put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static boolean is_empty(SearchUtil pageSearch) {
        return pageSearch == null || pageSearch.isEmpty();
    }
}