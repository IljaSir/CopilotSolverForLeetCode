class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = values.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] {values[i], labels[i]};
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int[] a : arr) {
            int label = a[1];
            if (count == numWanted) {
                break;
            }
            if (map.getOrDefault(label, 0) < useLimit) {
                map.put(label, map.getOrDefault(label, 0) + 1);
                sum += a[0];
                count++;
         
        return ans;
    }
}