class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int targetMinutes = targetSeconds / 60;
        int targetSecondsRemainder = targetSeconds % 60;
        int targetMinutesRemainder = targetMinutes % 100;
        int targetMinutesQuotient = targetMinutes / 100;
        int ans = 0;
        ans += pushCost * (targetSecondsRemainder % 10);
        ans += pushCost * (targetSecondsRemainder / 10);
        ans += pushCost * (targetMinutesRemainder % 10);
        ans += pushCost * (targetMinutesRemainder / 10);
        ans += pushCost * (targetMinutesQuotient % 10);
        ans += pushCost * (targetMinutesQuotient / 10);
        ans += moveCost * Math.min(Math.abs(startAt - targetSecondsRemainder % 10), 10 - Math.abs(startAt - targetSecondsRemainder % 10));
        ans += moveCost * Math.min(Math.abs(startAt - targetSecondsRemainder / 10), 10 - Math.abs(startAt - targetSecondsRemainder / 10));
        ans += moveCost * Math.min(Math.abs(startAt - targetMinutesRemainder % 10), 10 - Math.abs(startAt - targetMinutesRemainder % 10));
        ans += moveCost * Math.min(Math.abs(startAt - targetMinutesRemainder / 10), 10 - Math.abs(startAt - targetMinutesRemainder / 10));
        ans += moveCost * Math.min(Math.abs(startAt - targetMinutesQuotient % 10), 10 - Math.abs(startAt - targetMinutesQuotient % 10));
        ans += moveCost * Math.min(Math.abs(startAt - targetMinutesQuotient / 10), 10 - Math.abs(startAt - targetMinutesQuotient / 10));
        return ans;
    }
}