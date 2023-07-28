class Solution {
    public String[] getFolderNames(String[] names) {
        
        HashMap<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                map.put(names[i], 1);
                ans[i] = names[i];
            } else {
                int k = map.get(names[i]);
                while (map.containsKey(names[i] + "(" + k + ")")) {
                    k++;
                }
                ans[i] = names[i] + "(" + k + ")";
                map.put(names[i], k + 1);
                map.put(ans[i], 1);
            }
        }lt;
    }
}