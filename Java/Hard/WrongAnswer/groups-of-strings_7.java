class Solution {
    public int[] groupStrings(String[] words) {
        
        int maxGroup = 0;
        int maxGroupSize = 0;
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String key = getKey(word);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        for (String key : map.keySet()) {
            maxGroup++;
            maxGroupSize = Math.max(maxGroupSize, map.get(key).size());
        }
        return new int[]{maxGroup, maxGroupSize};
    }
    private String getKey(String word) {
        StringBuilder sb = new StringBuilder();
        int offset = word.charAt(0) - 'a';
        for (char c : word.toCharArray()) {
            sb.append((char) ((c - offset + 26) % 26 + 'a'));
        }
        return sb.toString();
    }
}