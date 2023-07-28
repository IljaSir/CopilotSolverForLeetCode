class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        
        int maxScore = 0;
        int curMax = values[0] + 0;
        for(int i = 1; i < values.size(); i++) {
            maxScore = max(maxScore, curMax + values[i] - i);
            curMax = max(curMax, values[i] + i);
        }
        return maxScore;
    }
};