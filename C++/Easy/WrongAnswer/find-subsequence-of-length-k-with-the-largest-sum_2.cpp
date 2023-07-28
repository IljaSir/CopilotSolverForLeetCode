class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> ans;
        for (int i = 0; i < n; i++) {
            while (ans.size() > 0 && ans.back() < nums[i] && ans.size() + n - i > k) {
                ans.pop_back();
            }
            if (ans.size() < k) {
                ans.push_back(nums[i]);
            }
        }
        return ans;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        vector<int> ans(k, 0);
        for (int i = max(0, k - n2); i <= min(n1, k); i++) {
            vector<int> candidate(k, 0);
            auto t1 = maxSubsequence(nums1, i);
            auto t2 = maxSubsequence(nums2, k - i);
            int ptr1 = 0, ptr2 = 0;
            for (int j = 0; j < k; j++) {
                candidate[j] = t1[ptr1] > t2[ptr2] ? t1[ptr1++] : t2[ptr2++];
            }
            ans = max(ans, candidate);
        }
        return ans;
    }
};