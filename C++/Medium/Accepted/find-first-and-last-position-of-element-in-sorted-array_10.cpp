class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int l = 0;
        int r = nums.size();
        int mid;
        vector<int> result;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l >= r) {
            result.push_back(-1);
            result.push_back(-1);
            return result;
        }
        int left = mid;
        int right = mid;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right < nums.size() && nums[right] == target) {
            right++;
        }
        result.push_back(left + 1);
        result.push_back(right - 1);
        return result;
    }
};