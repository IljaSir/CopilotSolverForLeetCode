class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        int m = n / 2;
        vector<int> left, right;
        for (int i = 0; i < (1 << m); i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (i & (1 << j)) {
                    sum += nums[j];
                }
            }
            left.push_back(sum);
        }
        for (int i = 0; i < (1 << (n - m)); i++) {
            int sum = 0;
            for (int j = 0; j < n - m; j++) {
                if (i & (1 << j)) {
                    sum += nums[j + m];
                }
            }
            right.push_back(sum);
        }
        sort(left.begin(), left.end());
        sort(right.begin(), right.end());
        int ans = abs(goal);
        for (int x : left) {
            int y = goal - x;
            auto it = lower_bound(right.begin(), right.end(), y);
            if (it != right.end()) {
                ans = min(ans, abs(x + *it - goal));
            }
            if (it != right.begin()) {
                ans = min(ans, abs(x + *prev(it) - goal));
            }
        }
        return ans;
    }
};