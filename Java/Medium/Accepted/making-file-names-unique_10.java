class Solution {
    public String[] getFolderNames(String[] names) {
        
        HashMap<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String s = names[i];
            if (!map.containsKey(s)) {
                map.put(s, 1);
                res[i] = s;
            } else {
                int k = map.get(s);
                while (map.containsKey(s + "(" + k + ")")) {
                    k++;
                }
                map.put(s + "(" + k + ")", 1);
                map.put(s, k + 1);
                res[i] = s + "(" + k + ")";
            }
        }
        return res;
    }
}