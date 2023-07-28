class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int indexDiff, int valueDiff) {
        
        set<int> s;
        for (int i = 0; i < nums.size(); i++) {
            if (i > indexDiff) s.erase(nums[i - indexDiff - 1]);
            auto pos = s.lower_bound(nums[i] - valueDiff);
            if (pos != s.end() && *pos - nums[i] <= valueDiff) return true;
            s.insert(nums[i]);
        }
        return false;
    }
};