class Solution {
    public int similarPairs(String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char)('a' + i));
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            ans += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return ans;
    }
}