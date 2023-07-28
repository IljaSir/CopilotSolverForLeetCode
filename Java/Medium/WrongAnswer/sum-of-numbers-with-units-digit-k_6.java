class Solution {
    public int minimumNumbers(int num, int k) {
        
        if (num == 0) {
            return 0;
        }
        if (num < k) {
            return -1;
        }
        int ans = 0;
        while (num > 0) {
            if (num >= k) {
                num -= k;
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}