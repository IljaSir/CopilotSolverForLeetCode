class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[][] numsIndex = new int[101][];
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            numsIndex[i] = new int[count[i]];
        }
        for (int i = 0; i < nums.length; i++) {
            numsIndex[nums[i]][--count[nums[i]]] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int minDiff = Integer.MAX_VALUE;
            int last = -1;
            for (int j = 1; j <= 100; j++) {
                int[] index = numsIndex[j];
                int index1 = binarySearch(index, query[0]);
                int index2 = binarySearch(index, query[1]);
                if (index1 < index.length && index1 <= index2) {
                    if (last != -1) {
                        minDiff = Math.min(minDiff, j - last);
                    }
                    last = j;
                }
            }
            ans[i] = minDiff == Integer.MAX_VALUE ? -1 : minDiff;
        }
        return ans;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}