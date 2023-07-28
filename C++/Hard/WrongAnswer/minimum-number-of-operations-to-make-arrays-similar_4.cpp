class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        
        long long res = 0;
        for (int i = 0; i < nums.size(); i++) {
            res += nums[i] - target[i];
        }
        return res;
    }
    int minOperations(vector<int>& nums, vector<int>& target) {
        int n = nums.size();
        vector<int> nums1, nums2;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                nums1.push_back(nums[i] - target[i]);
            } else {
                nums2.push_back(nums[i] - target[i]);
            }
        }
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int ans = n;
        for (int i = 0; i < nums1.size(); i++) {
            int j = upper_bound(nums2.begin(), nums2.end(), -nums1[i]) - nums2.begin();
            int k = lower_bound(nums2.begin(), nums2.end(), -nums1[i]) - nums2.begin();
            if (j >= 0 && j < nums2.size()) {
                ans = min(ans, i + 1 + (int)nums2.size() - j);
            }
            if (k >= 0 && k < nums2.size()) {
                ans = min(ans, i + 1 + (int)nums2.size() - k);
            }
        }
        for (int i = 0; i < nums2.size(); i++) {
            int j = upper_bound(nums1.begin(), nums1.end(), -nums2[i]) - nums1.begin();
            int k = lower_bound(nums1.begin(), nums1.end(), -nums2[i]) - nums1.begin();
            if (j >= 0 && j < nums1.size()) {
                ans = min(ans, i + 1 + (int)nums1.size() - j);
            }
            if (k >= 0 && k < nums1.size()) {
                ans = min(ans, i + 1 + (int)nums1.size() - k);
            }
        }
        if (ans == n) {
            return -1;
        }
        return ans;
    }
};