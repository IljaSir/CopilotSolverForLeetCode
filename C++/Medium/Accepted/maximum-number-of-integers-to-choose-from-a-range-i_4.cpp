class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        sort(banned.begin(), banned.end());
        int ans = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + i <= maxSum) {
                if (binary_search(banned.begin(), banned.end(), i)) {
                    continue;
                }
                sum += i;
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
};