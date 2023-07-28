class Solution {
public:
    string minInteger(string num, int k) {
        
        if (k == 0) return num;
        int n = num.size();
        vector<int> pos[10];
        for (int i = 0; i < n; ++i) {
            pos[num[i] - '0'].push_back(i);
        }
        string ans;
        for (int i = 0; i < n; ++i) {
            for (int d = 0; d < 10; ++d) {
                if (pos[d].empty()) continue;
                int j = pos[d][0];
                if (j - i <= k) {
                    k -= j - i;
                    ans.push_back('0' + d);
                    pos[d].erase(pos[d].begin());
                    for (int& p : pos[d]) --p;
                    break;
                }
            }
        }
        return ans;
    }
};