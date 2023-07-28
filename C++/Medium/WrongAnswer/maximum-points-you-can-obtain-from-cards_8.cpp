class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        
        int n = cardPoints.size();
        int sum = accumulate(cardPoints.begin(), cardPoints.end(), 0);
        int res = sum;
        int i = 0;
        for (int j = n - k; j < n; ++j) {
            sum -= cardPoints[i++];
            sum += cardPoints[j];
            res = min(res, sum);
        }
        return accumulate(cardPoints.begin(), cardPoints.end(), 0) - res;
    }
};