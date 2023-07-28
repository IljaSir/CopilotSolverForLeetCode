class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = values.length;
        int[][] v = new int[n][2];
        for (int i = 0; i < n; i++) {
            v[i][0] = values[i];
            v[i][1] = labels[i];
        }
        Arrays.sort(v, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n && numWanted > 0; i++) {
            int[] p = v[i];
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
            if (map.get(p[1]) <= useLimit) {
                res += p[0];
                numWanted--;
            }
        }
        return res;
    }
}