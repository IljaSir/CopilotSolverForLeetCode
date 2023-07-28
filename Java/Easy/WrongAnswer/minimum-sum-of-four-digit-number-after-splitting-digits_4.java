class Solution {
    public int minimumSum(int num) {
        
        String s = String.valueOf(num);
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum * 10 + a[j];
            }
            int num1 = sum;
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum * 10 + a[j];
            }
            int num2 = sum;
            min = Math.min(min, num1 + num2);
        }
        return min;
    }
}