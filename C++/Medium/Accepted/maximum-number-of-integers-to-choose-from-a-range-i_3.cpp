class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        sort(banned.begin(), banned.end());
        int sum = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + i <= maxSum && !binary_search(banned.begin(), banned.end(), i)) {
                sum += i;
                ans++;
            }
        }
        return ans;
    }
};