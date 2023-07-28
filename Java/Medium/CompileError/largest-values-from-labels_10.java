class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = values.length;
        nt[][ items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i] = new int[]{values[i], labels[i]};
        }
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n && numWanted > 0; i++) {
            int label = items[i][1];
            int cnt = count.getOrDefault(label, 0);
            if (cnt < useLimit) {
                res += items[i][0];
                count.put(label, cnt + 1);
                numWanted--;
            }
        }
        return res;
    }
}