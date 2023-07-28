class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String[] s1Array = s1.split(" ");
        String[] s2Array = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1Array) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        for (String s : s2Array) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String[] result = new String[list.size()];
        int i = 0;
        for (String s : list) {
            result[i++] = s;
        }
        return result;
    }
}