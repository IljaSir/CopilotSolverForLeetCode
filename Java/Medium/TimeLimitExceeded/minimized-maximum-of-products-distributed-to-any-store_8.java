class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int m = quantities.length;
        int[] count = new int[100001];
        for (int q : quantities) {
            count[q]++;
        }
        int[] prefix = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            prefix[i] = prefix[i - 1] + count[i];
        }
        int left = 0;
        int right = 100000;
        while (left < right) {
            int mid = (left + right) / 2;
            int index = 100000;
            int total = 0;
            while (index > 0 && total < n) {
                int c = Math.min(count[index], (n - total + mid - 1) / mid);
                total += c;
                index -= c;
            }
            if (total < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}