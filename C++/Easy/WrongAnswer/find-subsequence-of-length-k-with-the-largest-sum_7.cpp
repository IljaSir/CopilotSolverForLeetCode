class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> ans;
        for (int i = 0; i < n; ++i) {
            while (!ans.empty() && nums[i] > ans.back() && (n - i + ans.size() > k)) {
                ans.pop_back();
            }
            if (ans.size() < k) {
                ans.push_back(nums[i]);
            }
        }
        return ans;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size();
        int m = nums2.size();
        vector<int> ans;
        for (int i = max(0, k - m); i <= min(n, k); ++i) {
            vector<int> ans1 = maxSubsequence(nums1, i);
            vector<int> ans2 = maxSubsequence(nums2, k - i);
            vector<int> temp;
            int x = 0, y = 0;
            while (x < ans1.size() || y < ans2.size()) {
                temp.push_back(lexicographical_compare(ans1.begin() + x, ans1.end(), ans2.begin() + y, ans2.end()) ? ans2[y++] : ans1[x++]);
            }
            ans = max(ans, temp);
        }
        return ans;
    }
};