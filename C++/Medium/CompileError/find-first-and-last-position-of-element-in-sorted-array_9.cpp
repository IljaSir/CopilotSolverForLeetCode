class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        vector<int> result;
        int l = 0;
        int r = nums.size() - 1;
        int m;
        int pos = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                pos = m;
                break;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (pos == -1) {
            result.push_back(-1);
            result.push_back(-1);
            return result;
        }
        l = 0;
        r = pos;
        int left = pos;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                left = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = pos;
        r = nums.size() - 1;
        int right = pos;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                right = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        result.push_back(left);
        result.push_back(right);
        return result
    }
};