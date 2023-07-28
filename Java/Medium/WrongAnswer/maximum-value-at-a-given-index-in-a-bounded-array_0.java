class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        int left = 1;
        int right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(n, index, maxSum, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int n, int index, int maxSum, int mid) {
        long sum = mid;
        int left = index;
        int right = index;
        int num = 1;
        while (left >= 0 || right < n) {
            if (left >= 0 && right < n) {
                if (num < mid) {
                    sum += 2 * num;
                    num++;
                } else {
                    sum += num;
                }
                left--;
                right++;
            } else if (left >= 0) {
                if (num < mid) {
                    sum += 2 * num;
                    num++;
                } else {
                    sum += num;
                }
                left--;
            } else {
                if (num < mid) {
                    sum += 2 * num;
                    num++;
                } else {
                    sum += num;
                }
                right++;
            }
        }
        return sum <= maxSum;
    }
}