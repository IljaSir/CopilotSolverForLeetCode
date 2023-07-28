class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str : s1Arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : s2Arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) == 1) {
                list.add(str);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}