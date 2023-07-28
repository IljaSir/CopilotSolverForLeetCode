class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        
        int n = cardPoints.size();
        int sum = 0;
        for (int i = 0; i < k; ++i)
            sum += cardPoints[i];
        int res = sum;
        for (int i = 0; i < k; ++i) {
            sum -= cardPoints[k - i - 1];
            sum += cardPoints[n - i - 1];
            res = max(res, sum);
        }
        return res;
    }
};