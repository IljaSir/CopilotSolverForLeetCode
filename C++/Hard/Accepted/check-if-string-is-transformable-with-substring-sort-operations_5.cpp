class Solution {
public:
    bool isTransformable(string s, string t) {
        
        int n = s.size();
        vector<queue<int>> pos(10);
        for (int i = 0; i < n; ++i) {
            pos[s[i] - '0'].push(i);
        }
        for (int i = 0; i < n; ++i) {
            int d = t[i] - '0';
            if (pos[d].empty()) {
                return false;
            }
            for (int j = 0; j < d; ++j) {
                if (!pos[j].empty() && pos[j].front() < pos[d].front()) {
                    return false;
                }
            }
            pos[d].pop();
        }
        return true;
    }
};