class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        int n = times.size();
        vector<int> chairs(n);
        for (int i = 0; i < n; ++i) {
            chairs[i] = i;
        }
        vector<int> order(n);
        for (int i = 0; i < n; ++i) {
            order[i] = i;
        }
        sort(order.begin(), order.end(), [&](int a, int b) {
            return times[a][0] < times[b][0];
        });
        set<pair<int, int>> st;
        for (int i = 0; i < n; ++i) {
            auto& t = times[order[i]];
            while (!st.empty() && st.begin()->first <= t[0]) {
                chairs.push_back(st.begin()->second);
                st.erase(st.begin());
            }
            if (order[i] == targetFriend) {
                return chairs.back();
            }
            st.insert({t[1], chairs.back()});
            chairs.pop_back();
        }
        return -1;
    }
};