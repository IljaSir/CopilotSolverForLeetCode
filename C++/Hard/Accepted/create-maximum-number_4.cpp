class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<int> ans;
        for (int i = 0; i <= k; i++) {
            if (i <= nums1.size() && k - i <= nums2.size()) {
                vector<int> tmp = merge(maxNumber(nums1, i), maxNumber(nums2, k - i));
                if (greater(tmp, 0, ans, 0)) {
                    ans.swap(tmp);
                }
            }
        }
        return ans;
    }

    vector<int> merge(vector<int> nums1, vector<int> nums2) {
        vector<int> ans;
        while (!nums1.empty() || !nums2.empty()) {
            vector<int>& now = greater(nums1, 0, nums2, 0) ? nums1 : nums2;
            ans.push_back(now[0]);
            now.erase(now.begin());
        }
        return ans;
    }

    bool greater(vector<int>& nums1, int i, vector<int>& nums2, int j) {
        while (i < nums1.size() && j < nums2.size() && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.size() || (i < nums1.size() && nums1[i] > nums2[j]);
    }

    vector<int> maxNumber(vector<int>& nums, int k) {
        vector<int> ans;
        int drop = nums.size() - k;
        for (int i = 0; i < nums.size(); i++) {
            while (!ans.empty() && ans.back() < nums[i] && drop > 0) {
                ans.pop_back();
                drop--;
            }
            ans.push_back(nums[i]);
        }
        ans.resize(k);
        return ans;
    }
};