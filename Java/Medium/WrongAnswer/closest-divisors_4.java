class Solution {
    public int[] closestDivisors(int num) {
        
        int[] ans = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = (int)Math.sqrt(num + 1); i > 0; i--) {
            if ((num + 1) % i == 0) {
                min = Math.min(min, Math.abs(i - (num + 1) / i));
                ans[0] = i;
                ans[1] = (num + 1) / i;
            }
        }
        for (int i = (int)Math.sqrt(num + 2); i > 0; i--) {
            if ((num + 2) % i == 0) {
                if (Math.abs(i - (num + 2) / i) < min) {
                    ans[0] = i;
                    ans[1] = (num + 2) / i;
                }
            }
        }
        return ans;
    }
}