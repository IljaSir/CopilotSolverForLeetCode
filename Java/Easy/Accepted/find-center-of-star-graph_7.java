class Solution {
    public int findCenter(int[][] edges) {
        
        int[] cnt = new int[edges.length + 2];
        for (int[] e: edges) {
            cnt[e[0]]++;
            cnt[e[1]]++;
        }
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == edges.length) return i;
        }
        return -1;
    }
}