class Solution {
    public int minMaxDifference(int num) {
        
        int[] min = new int[10];
        int[] max = new int[10];
        Arrays.fill(min, 10);
        Arrays.fill(max, -1);
        int n = num;
        int i = 0;
        while (n > 0) {
            int d = n % 10;
            min[d] = Math.min(min[d], i);
            max[d] = Math.max(max[d], i);
            n /= 10;
            i++;
        }
        int res = 0;
        for (int d = 0; d < 10; d++) {
            if (min[d] == 10) {
                continue;
            }
            int m = num;
            int j = 0;
            int a = 0;
            while (m > 0) {
                int dd = m % 10;
                if (j == min[d]) {
                    dd = d;
                }
                a = a * 10 + dd;
                m /= 10;
                j++;
            }
            res = Math.max(res, a - num);
            for (int dd = 0; dd < 10; dd++) {
                if (max[dd] == -1 || dd == d) {
                    continue;
                }
                m = num;
                j = 0;
                a = 0;
                while (m > 0) {
                    int ddd = m % 10;
                    if (j == max[dd]) {
                        ddd = dd;
                    }
                    a = a * 10 + ddd;
                    m /= 10;
                    j++;
                }
                res = Math.max(res, num - a);
            }
        }
        return res;
    }
}