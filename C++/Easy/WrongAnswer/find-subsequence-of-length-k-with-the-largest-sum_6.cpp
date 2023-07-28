class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        
        vector<int> res;
        int n = nums.size();
        int m = n - k;
        for (int i = 0; i < n; ++i) {
            while (!res.empty() && res.back() < nums[i] && m > 0) {
                res.pop_back();
                --m;
            }
            res.push_back(nums[i]);
        }
        res.resize(k);
        return res;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size();
        int m = nums2.size();
        vector<int> res(k, 0);
        for (int i = max(0, k - m); i <= min(k, n); ++i) {
            vector<int> temp(k, 0);
            auto v1 = maxSubsequence(nums1, i);
            auto v2 = maxSubsequence(nums2, k - i);
            int pos = 0, pos1 = 0, pos2 = 0;
            while (pos1 < v1.size() || pos2 < v2.size()) {
                temp[pos++] = greater(v1, pos1, v2, pos2) ? v1[pos1++] : v2[pos2++];
            }
            res = greater(temp, 0, res, 0) ? temp : res;
        }
        return res;
    }
    bool greater(vector<int>& v1, int start1, vector<int>& v2, int start2) {
        while (start1 < v1.size() && start2 < v2.size() && v1[start1] == v2[start2]) {
            ++start1;
            ++start2;
        }
        return start2 == v2.size() || (start1 < v1.size() && v1[start1] > v2[start2]);
    }
};