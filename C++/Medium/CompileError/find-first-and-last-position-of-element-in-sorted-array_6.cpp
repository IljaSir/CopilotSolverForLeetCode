class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int l = 0;
        int r = nums_back(-1);
            res.push_back(-1);
            return res;
        }
        
        int left = mid;
        int right = mid;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right < nums.size() && nums[right] == target) {
            right++;
        }
        res.push_back(left + 1);
        res.push_back(right - 1);
        return res;
    }
};