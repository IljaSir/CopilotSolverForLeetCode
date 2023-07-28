class Solution {
public:
    string minInteger(string num, int k) {
        
        int n = num.size();
        string ans = "";
        vector<int> pos[10];
        for (int i = 0; i < n; i++) {
            pos[num[i] - '0'].push_back(i);
        }
        for (int i = 0; i < n; i++) {
            for (int d = 0; d < 10; d++) {
                if (pos[d].empty()) continue;
                int j = pos[d][0];
                int moves = j - i;
                if (moves <= k) {
                    k -= moves;
                    ans += '0' + d;
                    pos[d].erase(pos[d].begin());
                    for (int d2 = 0; d2 < 10; d2++) {
                        for (int & p : pos[d2]) {
                            if (p < j) p++;
                        }
                    }
                    break;
                }
            }
        }
        return ans;
    }
};