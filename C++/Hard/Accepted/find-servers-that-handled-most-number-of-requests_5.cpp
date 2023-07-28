class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        vector<int> ans;
        vector<int> cnt(k, 0);
        set<int> st;
        for (int i = 0; i < k; ++i) {
            st.insert(i);
        }
        int n = arrival.size();
        map<int, set<int>> mp;
        for (int i = 0; i < n; ++i) {
            int t = arrival[i];
            int l = load[i];
            while (!mp.empty() && mp.begin()->first <= t) {
                int idx = *(mp.begin()->second.begin());
                mp.begin()->second.erase(idx);
                if (mp.begin()->second.empty()) {
                    mp.erase(mp.begin());
                }
                st.insert(idx);
            }
            if (st.empty()) {
                continue;
            }
            auto it = st.lower_bound(i % k);
            if (it == st.end()) {
                it = st.begin();
            }
            int idx = *it;
            st.erase(idx);
            cnt[idx]++;
            mp[t + l].insert(idx);
        }
        int mx = *max_element(cnt.begin(), cnt.end());
        for (int i = 0; i < k; ++i) {
            if (cnt[i] == mx) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};