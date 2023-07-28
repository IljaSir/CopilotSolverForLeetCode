class Solution {
    public int countTriples(int n) {
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int a = i * i + j * j;
                int b = (int) Math.sqrt(a);
                if (b * b == a && b <= n) {
                    ans += 2;
                }
            }
        }
        return ans;
    }
}