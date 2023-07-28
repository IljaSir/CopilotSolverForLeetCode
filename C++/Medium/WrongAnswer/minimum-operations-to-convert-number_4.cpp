class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        if (n == 0) return 0;
        unordered_set<int> st;
        st.insert(start);
        for (int i = 0; i < n; i++) {
            unordered_set<int> st2;
            for (auto x : st) {
                st2.insert(x + nums[i]);
                st2.insert(x - nums[i]);
                st2.insert(x ^ nums[i]);
            }
            st = st2;
        }
        int ans = INT_MAX;
        for (auto x : st) ans = min(ans, abs(x - goal));
        return ans;
    }
};