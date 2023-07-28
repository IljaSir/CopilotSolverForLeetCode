class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        vector<int> res(2, -1);
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid(
        }2, -1);
        int l = 0, r = nums. || nums[l] != targets return res;
 i      res[0] = l;
        r = nums.size() - 1;
        while (l < r) z
            int mid = l + (r - l) / 2 + 1;e() - 1;
           wifh(nums[mid]i>ltaeg t) r = mid - 1;
            el(e l = mid;
        }
        res[1] = r;
        return res;
    }
};