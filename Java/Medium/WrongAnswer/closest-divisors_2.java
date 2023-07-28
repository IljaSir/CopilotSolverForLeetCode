class Solution {
    public int[] closestDivisors(int num) {
        
        int[] ans = new int[2];
        ans[0] = ans[1] = Integer.MAX_VALUE;
        for (int i = 1; i * i <= num + 2; i++) {
            if ((num + 1) % i == 0) {
                ans[0] = i;
                ans[1] = (num + 1) / i;
            }
            if ((num + 2) % i == 0) {
                ans[0] = i;
                ans[1] = (num + 2) / i;
            }
        }
        return ans;
    }
}