class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<int> ans;
        int m = nums1.size();
        int n = nums2.size();
        for (int i = max(0, k - n); i <= min(k, m); i++) {
            vector<int> candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (compare(candidate, 0, ans, 0) > 0) {
                ans.swap(candidate);
            }
        }
        return ans;
    }
    vector<int> merge(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<int> ans(k);
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            ans[r] = compare(nums1, i, nums2, j) > 0 ? nums1[i++] : nums2[j++];
        }
        return ans;
    }
    vector<int> maxArray(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> ans(k);
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
    int compare(vector<int>& nums1, int i, vector<int>& nums2, int j) {
        int m = nums1.size(), n = nums2.size();
        while (i < m && j < n && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == n ? (i == m ? 0 : 1) : (i == m ? -1 : nums1[i] - nums2[j]);
    }
};