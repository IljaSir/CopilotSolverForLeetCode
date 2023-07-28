class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = values.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{values[i], labels[i]};
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n && numWanted > 0; i++) {
            int label = arr[i][1];
            if (map.getOrDefault(label, 0) < useLimit) {
                map.put(label, map.getOrDefault(label, 0) + 1);
                res += arr[i][0];
                numWanted--;
            }
        }
        return res;
    }
}