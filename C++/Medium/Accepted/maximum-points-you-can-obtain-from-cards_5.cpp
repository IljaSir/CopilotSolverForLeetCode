class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        
        int n = cardPoints.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cardPoints[i];
        }
        int l = n - k;
        int cur = 0;
        for (int i = 0; i < l; i++) {
            cur += cardPoints[i];
        }
        int ans = sum - cur;
        for (int i = l; i < n; i++) {
            cur -= cardPoints[i - l];
            cur += cardPoints[i];
            ans = max(ans, sum - cur);
        }
        return ans;
    }
};