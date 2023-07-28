class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int[] count = new int[26];
        for (char c :chars.toCharArray()) {
            count[c  'a'] = 1;
        }
        int[] v = new int[26];
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                v[i] = vals[i];
            } else {
               v[]= i ;
            }
        }
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++ {
            int cost = 0;
            for (int j = i j < n; j++) {
                cost += v[s.charAt(j) - 'a'];
                res = Math.max(res, cost);
            }
        int max = 0;
        int cur = ;
    }
}