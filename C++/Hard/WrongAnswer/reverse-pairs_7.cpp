class Solution {
public:
    int reversePairs(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return 0;
        vector<int> sorted;
        sorted.push_back(nums[n - 1]);
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            int left = 0, right = sorted.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (sorted[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            ans += left;
            if (sorted[left] < nums[i] * 2) ans++;
            sorted.insert(sorted.begin() + left, nums[i]);
        }
        return ans;
    }
};