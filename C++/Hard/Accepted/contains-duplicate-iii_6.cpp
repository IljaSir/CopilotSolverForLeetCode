class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int indexDiff, int valueDiff) {
        
        multiset<long> st;
        for (int i = 0; i < nums.size(); i++) {
            if (i > indexDiff) st.erase(st.find(nums[i - indexDiff - 1]));
            auto it = st.lower_bound((long)nums[i] - valueDiff);
            if (it != st.end() && *it <= (long)nums[i] + valueDiff) return true;
            st.insert(nums[i]);
        }
        return false;
    }
};