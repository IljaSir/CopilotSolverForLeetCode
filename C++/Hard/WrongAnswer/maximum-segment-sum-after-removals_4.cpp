class Solution {
public:
    vector<long long> maximumSegmentSum(vector<int>& nums, vector<int>& removeQueries) {
        
        int n = nums.size();
        vector<long long> res(n, 0);
        vector<long long> pre(n, 0);
        vector<long long> suf(n, 0);
        vector<long long> dp(n, 0);
        set<int> st;
        for (int i = 0; i < n; ++i) {
            st.insert(i);
        }
        for (int i = 0; i < n; ++i) {
            pre[i] = nums[i];
            if (i > 0) {
                pre[i] += pre[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            suf[i] = nums[i];
            if (i < n - 1) {
                suf[i] += suf[i + 1];
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            int x = removeQueries[i];
            auto it = st.find(x);
            int l = 0, r = 0;
            if (it != st.begin()) {
                auto it2 = it;
                --it2;
                l = *it2;
            }
            ++it;
            if (it != st.end()) {
                r = *it;
            }
            --it;
            st.erase(it);
            dp[i] = pre[r] - pre[l] + suf[l] + suf[r];
            if (i < n - 1) {
                dp[i] = max(dp[i], dp[i + 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            res[i] = dp[i];
        }
        return res;
    }
};