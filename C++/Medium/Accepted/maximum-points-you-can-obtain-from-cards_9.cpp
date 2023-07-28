class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        
        int sum = accumulate(cardPoints.begin(), cardPoints.end(), 0);
        int n = cardPoints.size();
        int p = n - k;
        int cur = 0;
        for (int i = 0; i < p; ++i) {
            cur += cardPoints[i];
        }
        int res = sum - cur;
        for (int i = p; i < n; ++i) {
            cur += cardPoints[i];
            cur -= cardPoints[i-p];
            res = max(res, sum - cur);
        }
        return res;
    }
};