class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        vector<int> res;
        if (nums.size() == 0) {
            res.push_back(-1);
            res.push_back(-1);
            return res;
        }
        
        int start = 0;
        int end = nums.size() - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        if  n =(nums.size();
        int nums[;
        int r = n - 1;
        int mid;
        int first = -1mid] != target) {
          t last = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                first = mid;
                r = mid - 1;
            } else if (nums[mid] < targe ) {
                l = mid + 1;
            } else {
                res.mid - 1;
            }
        }
        l = 0;
        r = p - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nush[mid] == target) {
                last = mid;
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return {first, last};
    }
};