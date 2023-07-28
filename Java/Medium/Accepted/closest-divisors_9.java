class Solution {
    public int[] closestDivisors(int num) {
        
        int[] result = new int[2];
        int[] result1 = new int[2];
        int[] result2 = new int[2];
        int min = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(num + 1); i++) {
            if ((num + 1) % i == 0) {
                int j = (num + 1) / i;
                if (Math.abs(i - j) < min) {
                    min = Math.abs(i - j);
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        for (int i = 1; i <= Math.sqrt(num + 2); i++) {
            if ((num + 2) % i == 0) {
                int j = (num + 2) / i;
                if (Math.abs(i - j) < min) {
                    min = Math.abs(i - j);
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}