class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        
        int maxScore = 0, maxVal = values[0] + 0;
        for (int i = 1; i < values.size(); ++i) {
            maxScore = max(maxScore, maxVal + values[i] - i);
            maxVal = max(maxVal, values[i] + i);
        }
        return maxScore;
    }
};