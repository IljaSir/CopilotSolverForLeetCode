class Solution {
    public int minSwapsCouples(int[] row) {
        
        int[] pos = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            pos[row[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            int y = x % 2 == 0 ? x + 1 : x - 1;
            if (row[i + 1] == y) {
                continue;
            }
            ans++;
            int next = pos[y];
            int nextX = row[next];
            row[next] = row[i + 1];
            row[i + 1] = nextX;
            pos[nextX] = next;
            pos[y] = i + 1;
        }
        return ans;
    }
}