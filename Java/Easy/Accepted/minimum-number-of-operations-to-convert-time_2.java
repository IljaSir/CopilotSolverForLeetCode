class Solution {
    public int convertTime(String current, String correct) {
        
        String[] cur = current.split(":");
        String[] cor = correct.split(":");
        int h = Integer.parseInt(cor[0]) - Integer.parseInt(cur[0]);
        int m = Integer.parseInt(cor[1]) - Integer.parseInt(cur[1]);
        int time = 60 * h + m;
        int[] ops = {60, 15, 5, 1};
        int ans = 0;
        for (int i = 0; i < ops.length; i++) {
            ans += time / ops[i];
            time %= ops[i];
        }
        return ans;
    }
    public int minOperations(String current, String correct) {
        String[] cur = current.split(":");
        String[] cor = correct.split(":");
        int h = Integer.parseInt(cor[0]) - Integer.parseInt(cur[0]);
        int m = Integer.parseInt(cor[1]) - Integer.parseInt(cur[1]);
        int time = 60 * h + m;
        int[] ops = {60, 15, 5, 1};
        int ans = 0;
        for (int i = 0; i < ops.length; i++) {
            ans += time / ops[i];
            time %= ops[i];
        }
        return ans;
    }
}