class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int n = s.length();
        char[] arr = s.toCharArray();
        int ans = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 'a') {
                if (b > 0) {
                    --b;
                    ++ans;
                } else {
                    ++a;
                }
            } else if (arr[i] == 'b') {
                if (a > 0) {
                    --a;
                    ++ans;
                } else {
                    ++b;
                }
            } else {
                ans += Math.min(a, b);
                a = 0;
                b = 0;
            }
        }
        ans += Math.min(a, b);
        return ans * Math.max(x, y) + (x == y ? 0 : Math.min(a, b) * Math.min(x, y));
    }
}