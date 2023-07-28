class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return mincostTickets(days, costs, 0, dp);
    }
}