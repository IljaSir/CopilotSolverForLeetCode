class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        
        int n = cardPoints.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cardPoints[i];
        }
        if (k == n) {
            return sum;
        }
        int l = 0;
        int r = k - 1;
        int total = 0;
        for (int i = l; i <= r; i++) {
            total += cardPoints[i];
        }
        int ans = sum - total;
        while (r < n - 1) {
            total -= cardPoints[l];
            l++;
            r++;
            total += cardPoints[r];
            ans = max(ans, sum - total);
        }
        return ans;
    }
};