class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int count0 = 0, count1 = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') count0++;
            else count1++;
        }
        if(Math.abs(count0 - count1) > 1) return -1;
        if(count0 > count1) return solve(s, '0');
        else if(count1 > count0) return solve(s, '1');
        else return Math.min(solve(s, '0'), solve(s, '1'));
    }

    private int solve(String s, char c) {
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != c) res++;
            c = c == '0' ? '1' : '0';
        }
        return res / 2;
    }
}