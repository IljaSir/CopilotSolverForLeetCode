class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        s += s;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < i + n; j++) {
                if (s.charAt(j) != (j - i) % 2 == 0 ? '0' : '1') {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }
        return min;
    }
}