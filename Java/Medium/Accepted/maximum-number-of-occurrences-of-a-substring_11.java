class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            for (int j = i; j < n; j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                if (count.size() > maxLetters) {
                    break;
                }
                if (j - i + 1 >= minSize) {
                    String sub = s.substring(i, j + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                    ans = Math.max(ans, map.get(sub));
                }
            }
        }
        return ans;
    }
}