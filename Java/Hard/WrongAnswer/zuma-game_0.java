class Solution {
    public int findMinStep(String board, String hand) {
        
        int[] balls = new int[128];
        for (char c: hand.toCharArray()) balls[c]++;
        int ans = dfs(board + "#", balls);
        return ans == 6 ? -1 : ans;
    }
    private int dfs(String s, int[] balls) {
        s = removeConsecutive(s);
        if (s.equals("#")) return 0;
        int ans = 6, need = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);
            if (balls[s.charAt(i)] >= need) {
                balls[s.charAt(i)] -= need;
                ans = Math.min(ans, need + dfs(s.substring(0, i) + s.substring(j), balls));
                balls[s.charAt(i)] += need;
            }
            i = j;
        }
        return ans;
    }
    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i)) continue;
            if (j - i >= 3) return removeConsecutive(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }
}