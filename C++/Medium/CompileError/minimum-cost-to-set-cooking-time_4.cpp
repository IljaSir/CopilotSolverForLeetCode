class Solution {
public:
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int targetMinutes = targetSeconds / 60;
        int targetSeconds = targetSeconds % 60;
        int res = 0;
        while (targetMinutes > 0) {
            int digit = targetMinutes % 10;
            res += min(abs(digit - startAt) * moveCost, (10 - abs(digit - startAt)) * moveCost);
            res += pushCost;
            targetMinutes /= 10;
        }
        while (targetSeconds > 0) {
            int digit = targetSeconds % 10;
            res += min(abs(digit - startAt) * moveCost, (10 - abs(digit - startAt)) * moveCost);
            res += pushCost;
            targetSeconds /= 10;
        }
        return res;
    }
};