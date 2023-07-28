class Solution {
    public int minOperations(int n) {
        
        int s = 0;
        for(int i = 0; i < n; i++) {
            s += (i * 2 + 1);
        }
        s /= n;
        int cnt = 0;
        for(int i = 0; i < n / 2; i++) {
            cnt += (s - (i * 2 + 1));
        }
        return cnt;
    }
}