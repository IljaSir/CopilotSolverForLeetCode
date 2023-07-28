class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.length();
        int res = 0;
        int[] count = new int[26];
        for (int i = 0; i < minSize; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int unique = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) unique++;
        }
        Map<String, Integer> map = new HashMap<>();
        if (unique <= maxLetters) {
            map.put(s.substring(0, minSize), 1);
        }
        for (int i = minSize; i < n; i++) {
            count[s.charAt(i - minSize) - 'a']--;
            if (count[s.charAt(i - minSize) - 'a'] == 0) unique--;
            count[s.charAt(i) - 'a']++;
         
        return ans;
    }
}