class Solution {
    public int minOperations(int n) {
        
        int res = 0;
        int i = 0;
        while (i < n / 2) {
            res += n - (2 * i + 1);
            i++;
        }
        return res;
    }
}