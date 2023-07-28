class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        int n = packages.length;
        int m = boxes.length;
        Arrays.sort(packages);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += packages[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.sort(boxes[i]);
            if (boxes[i][boxes[i].length - 1] < packages[n - 1]) {
                continue;
            }
            int j = 0;
            long res = 0;
            for (j = 0; j < boxes[i].length; j++) {
                int index = find(boxes[i][j], packages);
                if (index == -1) {
                    break;
                }
                res += (long) boxes[i][j] * (index - j);
            }
            if (j == boxes[i].length) {
                ans = Math.min(ans, res - sum);
            }
        }
        return ans == Long.MAX_VALUE ? -1 : (int) (ans % 1000000007);
    }
    public int find(int target, int[] packages) {
        int left = 0;
        int right = packages.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (packages[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return packages[left] <= target ? left : left - 1;
    }
}