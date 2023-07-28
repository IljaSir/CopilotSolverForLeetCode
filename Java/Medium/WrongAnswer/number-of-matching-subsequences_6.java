class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                if (map.get(word) == 1) {
                    ans++;
                }
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for (String word : map.keySet()) {
            if (isSubSequence(s, word)) {
                ans += map.get(word) - 1;
            }
        }
        return ans;
    }

    private boolean isSubSequence(String s, String word) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < word.length() && c == word.charAt(i)) {
                i++;
            }
        }
        return i == word.length();
    }
}