class Solution {
    public String[] getFolderNames(String[] names) {
        
        String[] res = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name, 1);
            } else {
                int k = map.get(name);
                while (map.containsKey(name + "(" + k + ")")) {
                    k++;
                }
                name = name + "(" + k + ")";
                map.put(name, 1);
                map.put(names[i], k + 1);
                res[i] = name;
            }
        }
        return res;
    }
}