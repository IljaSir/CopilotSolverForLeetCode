class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> v1, v2;
        for (int i = 0; i < (1 << n / 2); ++i) {
            int sum = 0;
            for (int j = 0; j < n / 2; ++j) {
                if (i >> j & 1) {
                    sum += nums[j];
                }
            }
            v1.push_back(sum);
        }
        for (int i = 0; i < (1 << n - n / 2); ++i) {
            int sum = 0;
            for (int j = 0; j < n - n / 2; ++j) {
                if (i >> j & 1) {
                    sum += nums[n / 2 + j];
                }
            }
            v2.push_back(sum);
        }
        sort(v2.begin(), v2.end());
        int ans = INT_MAX;
        for (int x : v1) {
            int left = 0, right = v2.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (v2[mid] + x >= goal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left < v2.size()) {
                ans = min(ans, abs(v2[left] + x - goal));
            }
            if (right >= 0) {
                ans = min(ans, abs(v2[right] + x - goal));
            }
        }
        return ans;
    }
};