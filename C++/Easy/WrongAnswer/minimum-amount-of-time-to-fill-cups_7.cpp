class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int minTime = 0;
        int minCup = 0;
        for (int i = 0; i < amount.size(); i++) {
            if (amount[i] < amount[minCup]) {
                minCup = i;
            }
            minTime += amount[i];
        }
        minTime -= amount[minCup];
        return minTime;
    }
};