class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr2);
        int[] dp = new int[n];
        int[] tmp = new int[n];
        int[] tmp2 = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr1[i] <= arr1[i - 1]) {
                int j = Arrays.binarySearch(arr2, arr1[i - 1] + 1);
                if (j < 0) {
                    j = -j - 1;
                }
                if (j < m) {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            if (arr1[i] <= arr1[i - 1]) {
                int j = Arrays.binarySearch(arr2, arr1[i - 1] + 1);
                if (j < 0) {
                    j = -j - 1;
                }
                if (j < m) {
                    tmp[i] = tmp[i - 1] + 1;
                }
            } else {
                tmp[i] = tmp[i - 1];
            }
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n; i++) {
                tmp2[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < n; i++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    if (arr1[i] < arr2[k]) {
                        tmp2[i] = Math.min(tmp2[i], dp[i]);
                    }
                    if (i > 0 && arr1[i - 1] < arr2[k]) {
                        tmp2[i] = Math.min(tmp2[i], dp[i - 1]);
                    }
                }
            }
            int[] t = dp;
            dp = tmp2;
            tmp2 = t;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min
    }
}