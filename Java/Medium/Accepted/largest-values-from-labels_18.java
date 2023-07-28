class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = values.length;
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i] = new int[] { values[i], labels[i] };
        }
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        int ans = 0;
        int[] used = new int[20001];
        for (int[] item : items) {
            int v = item[0], l = item[1];
            if (used[l] < useLimit) {
                ans += v;
                used[l]++;
                numWanted--;
                if (numWanted == 0) {
                    break;
                }
            }
        }
        return ans;
    }
}