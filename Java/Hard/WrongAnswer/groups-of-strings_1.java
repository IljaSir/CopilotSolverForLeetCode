class Solution {
    public int[] groupStrings(String[] words) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < word.length(); i++) {
                int diff = word.charAt(i) - word.charAt(i - 1);
                if (diff < 0) {
                    diff += 26;
                }
                sb.append(diff);
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key, list);
        }
        int maxGroup = 0;
        int maxGroupSize = 0;
        for (List<String> list : map.values()) {
            maxGroup++;
            maxGroupSize = Math.max(maxGroupSize, list.size());
        }
        return new int[]{maxGroup, maxGroupSize};
    }
}