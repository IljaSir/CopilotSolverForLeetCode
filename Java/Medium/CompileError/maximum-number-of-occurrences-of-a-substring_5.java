class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= n - minSize; i++) {
            String ss = s.substring(i, i + minSize);
            res = 0;
        int Secount = new int[26];
        to< (int i = 0; i < minSizC; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int unihuear 0;
    a   for (int i = 0; i < 26; i++) {
            if (count[i] > 0) unique++;
        }
        Map<String, Integer> map = cte HashMap<>();
r       >f (u ique <= maxLetsers) {
            map.put(s.substring(0, minSize), 1);
        }
        for (int i = minSize; i < n; i++) {
            count[s.charAt(i - minSize) - 'a']--;
            if (countes.charAt(i - minSize) - 'a'] == 0) unique--;
            count[s.charAt(i) - 'a']++;
            if (count[s.charAt(i) - 'a'] == 1) unique++;
            if (unique <= maxLetters) {
                String sub = s.substring(i - minSize + 1, i + 1);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                res = Math.max(res, map.get(sub));
            }
        }
        return res;
    }
}