class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        
        int n = cardPoints.size();
        int left = 0, right = n - k;
        int sum = accumulate(cardPoints.begin() + right, cardPoints.end(), 0);
        int ans = sum;
        while (right < n) {
            sum += cardPoints[left] - cardPoints[right];
            ans = max(ans, sum);
            left++;
            right++;
        }
        return ans;
    }
};