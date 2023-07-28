class Solution {
public:
    int minDeletions(string s) {
        
        unordered_map<char, int> m;
        for (auto c : s) {
            m[c]++;
        }
        unordered_set<int> st;
        int ans = 0;
        for (auto& p : m) {
            while (st.count(p.second)) {
                p.second--;
                ans++;
            }
            if (p.second > 0) {
                st.insert(p.second);
            }
        }
        return ans;
    }
};