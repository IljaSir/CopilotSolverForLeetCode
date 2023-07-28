class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int indexDiff, int valueDiff) {
        
        set<long long> st;
        for (int i = 0; i < nums.size(); i++) {
            if (i > indexDiff) st.erase(nums[i - indexDiff - 1]);
            auto pos = st.lower_bound((long long)nums[i] - valueDiff);
            if (pos != st.end() && *pos - nums[i] <= valueDiff) return true;
            st.insert(nums[i]);
        }
        return false;
    }
};