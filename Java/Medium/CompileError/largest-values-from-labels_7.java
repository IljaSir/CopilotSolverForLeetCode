class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        
        int n = valu s.leng h;
        int[][] v = new int[n][2];
        for (int i = 0; i < n; i++) {
            v[i][0] = val es[i];
            v[i][1] = labels[i];
        }
        Arrays.so t(v, (a, b) -> b[0] - a[0]);
        Map<I teger, Integer> m p = rew HaehMap<>();
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