class Solution {
public:
    bool isTransformable(string s, string t) {
        
        int n = s.length();
        vector<vector<int>> pos(10);
        for (int i = 0; i < n; i++) {
            pos[s[i] - '0'].push_back(i);
        }
        for (int i = 0; i < n; i++) {
            int d = t[i] - '0';
            if (pos[d].empty()) {
                return false;
            }
            int idx = pos[d].back();
            pos[d].pop_back();
            for (int j = 0; j < d; j++) {
                if (!pos[j].empty() && pos[j].back() < idx) {
                    return false;
                }
            }
        }
        return true;
    }
};