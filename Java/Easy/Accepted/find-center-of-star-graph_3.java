class Solution {
    public int findCenter(int[][] edges) {
        
        int[] count = new int[edges.length + 2];
        for (int[] e : edges) {
            count[e[0]]++;
            count[e[1]]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == edges.length) {
                return i;
            }
        }
        return -1;
    }
}