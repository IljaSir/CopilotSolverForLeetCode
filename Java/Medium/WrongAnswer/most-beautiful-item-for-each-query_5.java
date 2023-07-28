class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int[] ans = new int[queries.length];
        int[] maxBeauty = new int[items.length];
        maxBeauty[0] = items[0][1];
        for (int i = 1; i < items.length; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }
        for (int i = 0; i < queries.length; i++) {
            int index = binarySearch(items, queries[i]);
            ans[i] = index == -1 ? 0 : maxBeauty[index];
        }
        return ans;
    }
    private int binarySearch(int[][] items, int target) {
        int l = 0, r = items.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (items[mid][0] == target) {
                return mid;
            }
            if (items[mid][0] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (items[l][0] > target) {
            return l - 1;
        }
        return l;
    }
}