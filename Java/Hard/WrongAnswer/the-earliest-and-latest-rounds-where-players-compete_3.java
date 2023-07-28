class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] res = new int[2];
        res[0] = Math.min(firstPlayer, secondPlayer);
        res[1] = Math.max(firstPlayer, secondPlayer);
        while (res[0] % 2 == 0 && res[1] - res[0] == 1) {
            res[0] /= 2;
            res[1] = (res[1] + 1) / 2;
        }
        res[0] = (int)(Math.log(res[0]) / Math.log(2)) + 1;
        res[1] = (int)(Math.log(res[1]) / Math.log(2)) + 1;
        return res;
    }
}