class Solution {
    public int minMaxDifference(int num) {
        
        int[] arr = new int[10];
        int min = 10, max = 0;
        int n = num;
        while (n > 0) {
            int d = n % 10;
            if (d < min)
                min = d;
            if (d > max)
                max = d;
            n /= 10;
        }
        if (min == max)
            return 0;
        n = num;
        while (n > 0) {
            int d = n % 10;
            if (d == min)
                arr[max] = 1;
            if (d == max)
                arr[min] = 1;
            n /= 10;
        }
        int m = 0, M = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i] == 1) {
                m = m * 10 + i;
                M = M * 10 + i;
            } else {
                m = m * 10 + min;
                M = M * 10 + max;
            }
        }
        return M - m;
    }
}