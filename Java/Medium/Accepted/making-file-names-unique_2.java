class Solution {
    public String[] getFolderNames(String[] names) {
        
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name, 1);
            } else {
                int index = map.get(name);
                while (map.containsKey(name + "(" + index + ")")) {
                    index++;
                }
                res[i] = name + "(" + index + ")";
                map.put(name, index + 1);
                map.put(res[i], 1);
            }
        }
        return res;
    }
}