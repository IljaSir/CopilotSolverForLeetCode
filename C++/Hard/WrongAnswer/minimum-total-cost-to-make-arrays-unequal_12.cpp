class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> count(n+1, 0);
        vector<int> common;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                common.push_back(nums1[i]);
            } else {
                count[nums1[i]]++;
                count[nums2[i]]++;
            }
        }
        int min = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                min++;
                max++;
            } else if (count[i] == 1) {
                max++;
            }
        }
        if (min > common.size() || max < common.size()) {
            return -1;
        }
        long long ret = 0;
        for (int i = 0; i < common.size(); i++) {
            if (min > 0) {
                ret += i;
                min--;
            } else {
                ret += (common.size() - 1);
            }
        }
        return ret;
    }
};