class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String[] s1Split = s1.split(" ");
        String[] s2Split = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1Split) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2Split) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[list.size()]);
    }
}