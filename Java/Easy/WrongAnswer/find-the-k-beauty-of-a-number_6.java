class Solution {
    public int divisorSubstrings(int num, int k) {
        
        int ret = 0;
        String s = String.valueOf(num);
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            if (sub.charAt(0) == '0') continue;
            int n = Integer.parseInt(sub);
            if (num % n == 0) ret++;
        }
        return ret;
    }
}