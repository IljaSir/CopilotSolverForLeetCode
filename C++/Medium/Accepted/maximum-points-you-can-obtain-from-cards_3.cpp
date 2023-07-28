class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        
        int n = cardPoints.size();
        int total = accumulate(cardPoints.begin(), cardPoints.end(), 0);
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += cardPoints[i];
        }
        int ans = total - sum;
        for (int i = n - k; i < n; i++) {
            sum -= cardPoints[i - n + k];
            sum += cardPoints[i];
            ans = max(ans, total - sum);
        }
        return ans;
    }
};