class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        
        int n = cardPoints.size();
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                s += cardPoints[i];
            } else {
                s += cardPoints[i] - cardPoints[i-k];
            }
        }
        int ans = s;
        for (int i = 0; i < k; i++) {
            s += cardPoints[n-k+i] - cardPoints[i];
            ans = max(ans, s);
        }
        return ans;
    }
};