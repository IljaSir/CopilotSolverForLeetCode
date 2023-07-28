class Solution {
    public int[] closestDivisors(int num) {
        
        int[] ans = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(num + 2); i++) {
            if ((num + 1) % i == 0) {
                if (Math.abs((num + 1) / i - i) < min) {
                    min = Math.abs((num + 1) / i - i);
                    ans[0] = (num + 1) / i;
                    ans[1] = i;
                }
            }
            if ((num + 2) % i == 0) {
                if (Math.abs((num + 2) / i - i) < min) {
                    min = Math.abs((num + 2) / i - i);
                    ans[0] = (num + 2) / i;
                    ans[1] = i;
                }
            }
        }
        return ans;
    }
}