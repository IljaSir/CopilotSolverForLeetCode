class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int[] ans = new int[queries.length];
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[] max = new int[items.length];
        max[0] = items[0][1];
        for (int i = 1; i < items.length; i++) {
            max[i] = Math.max(max[i-1], items[i][1]);
        }
        for (int i = 0; i < queries.length; i++) {
            int index = binarySearch(items, queries[i]);
            if (index >= 0) {
                ans[i] = max[index];
            }
        }
        return ans;
    }
    
    private int binarySearch(int[][] items, int target) {
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}