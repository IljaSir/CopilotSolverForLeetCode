class Solution {
    public int[] closestDivisors(int num) {
        
        int[] ans = new int[2];
        int[] ans1 = new int[2];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(num + 1); i++) {
            if ((num + 1) % i == 0) {
                if (Math.abs(i - (num + 1) / i) < min1) {
                    min1 = Math.abs(i - (num + 1) / i);
                    ans[0] = i;
                    ans[1] = (num + 1) / i;
                }
            }
        }
        for (int i = 1; i <= Math.sqrt(num + 2); i++) {
            if ((num + 2) % i == 0) {
                if (Math.abs(i - (num + 2) / i) < min2) {
                    min2 = Math.abs(i - (num + 2) / i);
                    ans1[0] = i;
                    ans1[1] = (num + 2) / i;
                }
            }
        }
        if (min1 < min2) {
            return ans;
        } else {
            return ans1;
        }
    }
}