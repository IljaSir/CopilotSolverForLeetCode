class Solution {
    public int[] closestDivisors(int num) {
        
        int[] res = new int[2];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(num + 2); i++) {
            if ((num + 1) % i == 0) {
                int diff = Math.abs(i - (num + 1) / i);
                if (diff < minDiff) {
                    minDiff = diff;
                    res[0] = i;
                    res[1] = (num + 1) / i;
                }
            }
            if ((num + 2) % i == 0) {
                int diff = Math.abs(i - (num + 2) / i);
                if (diff < minDiff) {
                    minDiff = diff;
                    res[0] = i;
                    res[1] = (num + 2) / i;
                }
            }
        }
        return res;
    }
}