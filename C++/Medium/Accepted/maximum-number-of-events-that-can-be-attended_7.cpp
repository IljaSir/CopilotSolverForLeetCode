class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        
        int n = events.size();
        sort(events.begin(), events.end(), [](auto &a, auto &b){return a[1] < b[1];});
        int ans = 0;
        set<int> st;
        for (int i = 1; i <= 1e5; i++) {
            st.insert(i);
        }
        for (int i = 0; i < n; i++) {
            auto it = st.lower_bound(events[i][0]);
            if (it != st.end() && *it <= events[i][1]) {
                ans++;
                st.erase(it);
            }
        }
        return ans;
    }
};