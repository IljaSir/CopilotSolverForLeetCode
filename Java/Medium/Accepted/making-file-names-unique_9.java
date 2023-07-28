class Solution {
    public String[] getFolderNames(String[] names) {
        
        int n = names.length;
        String[] result = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                map.put(name, 1);
                result[i] = name;
            } else {
                int count = map.get(name);
                while (map.containsKey(name + "(" + count + ")")) {
                    count++;
                }
                map.put(name, count + 1);
                map.put(name + "(" + count + ")", 1);
                result[i] = name + "(" + count + ")";
            }
        }
        return result;
    }
}