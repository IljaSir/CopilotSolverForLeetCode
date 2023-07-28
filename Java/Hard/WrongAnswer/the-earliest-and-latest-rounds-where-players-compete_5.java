class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] res = new int[2];
        int min = Math.min(firstPlayer, secondPlayer);
        int max = Math.max(firstPlayer, secondPlayer);
        res[0] = (int) (Math.ceil(Math.log(min) / Math.log(2)) + Math.ceil(Math.log(n - max + 1) / Math.log(2)));
        res[1] = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        return res;
    }
}