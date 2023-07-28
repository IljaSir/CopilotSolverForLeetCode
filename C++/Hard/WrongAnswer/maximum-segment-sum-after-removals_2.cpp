class Solution {
public:
    vector<long long> maximumSegmentSum(vector<int>& nums, vector<int>& removeQueries) {
        
        int n = nums.size();
        vector<long long> ans(n);
        set<int> st;
        st.insert(0);
        st.insert(n);
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            auto it = st.lower_bound(removeQueries[i]);
            int r = *it;
            it--;
            int l = *it;
            ans[i] = sum;
            sum -= nums[removeQueries[i]];
            if (l < removeQueries[i]) {
                st.insert(removeQueries[i]);
            }
        }
        return ans;
    }
};