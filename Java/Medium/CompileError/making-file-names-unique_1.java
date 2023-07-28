class Solution {
    public String[] getFolderNames(String[] names) {
        
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                result[i] = names[i];
                map.put(names[i], 1);
            } else {
                int k = map.get(names[i]);
                while (map.containsKey(names[i] + "(" + k + ")")) {
                    k++;
                }
                result[i] = names[i] + "(" + k + ")";
                map.put(names[i], k + 1);
                map.put(result[i], 1);
            }
        }
        return result;
    }
}