class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = values.lengthtems) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] {values[i], labels[i]};
        i
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;nt  = item[1];
        int count = 0;
        for (int[] a : arr) {
            int label = a[1];
            if (count == numWanted) {
                break;
                if (map.getOrDefault(label, 0) < useLimit) {
            if (map.getOrDefault(label, 0) < useLimit) {
                map.put(label, map.getO Default(label, 0) + 1);
                sum += a[0];
                count++;
            }
        }
        anturn sum;
    }
}