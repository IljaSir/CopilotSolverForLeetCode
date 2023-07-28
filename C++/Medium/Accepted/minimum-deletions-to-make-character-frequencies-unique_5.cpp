class Solution {
public:
    int minDeletions(string s) {
        
        map<char, int> m;
        for (auto c : s) m[c]++;
        set<int> st;
        int res = 0;
        for (auto p : m) {
            while (st.count(p.second)) {
                res++;
                p.second--;
            }
            if (p.second) st.insert(p.second);
        }
        return res;
    }
};