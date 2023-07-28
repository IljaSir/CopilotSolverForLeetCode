class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = values.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{values[i], labels[i]
            arr[i][1] = labels[i];
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int label = arr[i][1];
            int count = map.getOrDefault(label, 0);
            if (count < useLimit) {
                res += arr[i][0];
                numWanted--;
                map.put(label, count + 1);
            }
            if (numWanted == 0) {
                break;
            }
        }
        return res;
    }
}