class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        int[] c = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            c[s.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (c[i] > 0) {
                min = Math.min(min, c[i]);
            }
        }
        if (min > repeatLimit) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt < repeatLimit) {
                sb.append(s.charAt(i));
                cnt++;
            } else {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    sb.append(s.charAt(i));
                    cnt = 1;
                }
            }
        }
        return sb.toString();
    }
}