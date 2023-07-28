class Solution {
    public int waysToBuildRooms(int[] prevRoom) {
        
        int n = prevRoom.length;
        int[] children = new int[n];
        for (int i = 1; i < n; i++) {
            children[prevRoom[i]]++;
        }
        long[] factorial = new long[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i % 1000000007;
        }
        return (int) dfs(prevRoom, children, factorial, 0);
    }
    private long dfs(int[] prevRoom, int[] children, long[] factorial, int root) {
        long ret = 1;
        for (int i = 0; i < children.length; i++) {
            if (prevRoom[i] == root) {
                ret *= factorial[children[i]];
                ret %= 1000000007;
                ret *= dfs(prevRoom, children, factorial, i);
                ret %= 1000000007;
            }
        }
        return ret;
    }
}