class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<int> res(k, 0);
        int m = nums1.size(), n = nums2.size();
        for (int i = max(0, k - n); i <= min(k, m); i++) {
            vector<int> candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, res, 0)) res = candidate;
        }
        return res;
    }
    
    vector<int> merge(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<int> res(k, 0);
        for (int i = 0, j = 0, r = 0; r < k; r++)
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return res;
    }
    
    vector<int> maxArray(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> res(k, 0);
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i]) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }
    
    bool greater(vector<int>& nums1, int i, vector<int>& nums2, int j) {
        while (i < nums1.size() && j < nums2.size() && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.size() || (i < nums1.size() && nums1[i] > nums2[j]);
    }
};