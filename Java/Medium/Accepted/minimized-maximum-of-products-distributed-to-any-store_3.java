class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int sum = 0;
        for (int q : quantities) {
            sum += q;
        }
        int min = sum / n;
        if (sum % n != 0) {
            min++;
        }
        int max = 0;
        for (int q : quantities) {
            max = Math.max(max, q);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canDistribute(n, quantities, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    
    private boolean canDistribute(int n, int[] quantities, int max) {
        int count = 0;
        for (int q : quantities) {
            count += q / max;
            if (q % max != 0) {
                count++;
            }
        }
        return count <= n;
    }
}