class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] sum = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            sum[i] = s;
        }
        int[] minLen = new int[n];
        minLen[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minLen[i] = minLen[i - 1];
            if (sum[i] == target) {
                minLen[i] = 1;
            } else if (sum[i] > target) {
                int idx = binarySearch(sum, 0, i - 1, sum[i] - target);
                if (idx != -1) {
                    minLen[i] = Math.min(minLen[i], i - idx);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        int maxLen = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 1; i--) {
            if (sum[i] == target) {
                maxLen = Math.min(maxLen, i + 1);
            } else if (sum[i] > target) {
                int idx = binarySearch(sum, 0, i - 1, sum[i] - target);
                if (idx != -1) {
                    maxLen = Math.min(maxLen, i - idx);
                }
            }
            if (minLen[i - 1] != Integer.MAX_VALUE) {
                res = Math.min(res, maxLen + minLen[i - 1]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int binarySearch(int[] arr, int l, int r, int target) {
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                res = mid;
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}