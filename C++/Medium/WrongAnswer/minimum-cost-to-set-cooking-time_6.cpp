class Solution {
public:
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int minCost = INT_MAX;
        int minPushCost = pushCost * 2;
        int minMoveCost = moveCost * 2;
        for (int i = 0; i < 100; ++i) {
            int cost = 0;
            int seconds = i * 60;
            int diff = targetSeconds - seconds;
            if (diff < 0) {
                break;
            }
            int minutes = diff / 60;
            int sec = diff % 60;
            int m1 = minutes / 10;
            int m2 = minutes % 10;
            int s1 = sec / 10;
            int s2 = sec % 10;
            if (m1 != 0) {
                cost += minPushCost + (abs(startAt - m1) * minMoveCost);
            } else {
                cost += minPushCost + (abs(startAt - m2) * minMoveCost);
            }
            cost += minPushCost + (abs(m1 - m2) * minMoveCost);
            cost += minPushCost + (abs(m2 - s1) * minMoveCost);
            cost += minPushCost + (abs(s1 - s2) * minMoveCost);
            minCost = min(minCost, cost);
        }
        return minCost;
    }
};