class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        int n = nums.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    int largestNumber(vector<int>& nums) {
        // sort(nums.begin(), nums.end());
        int n = nums.size();
        if (n == 0) {
            return -1;
        }
        int k = findMaxK(nums);
        if (k == 0) {
            return -1;
        }
        int l = -1, r = k - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] == -nums[k]) {
                return nums[k];
            } else if (nums[mid] > -nums[k]) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (l >= 0 && nums[l] == -nums[k]) {
            return nums[k];
        }
        return -1;
    }
};