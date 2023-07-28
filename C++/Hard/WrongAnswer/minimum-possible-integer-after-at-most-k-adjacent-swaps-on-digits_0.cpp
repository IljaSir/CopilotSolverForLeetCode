class Solution {
public:
    string minInteger(string num, int k) {
        
        int n = num.size();
        vector<queue<int>> pos(10);
        for (int i = 0; i < n; ++i) {
            pos[num[i] - '0'].push(i);
        }
        string ans;
        for (int i = 0; i < n; ++i) {
            for (int d = 0; d < 10; ++d) {
                if (pos[d].empty()) continue;
                int j = pos[d].front();
                if (j - i <= k) {
                    k -= j - i;
                    ans.push_back('0' + d);
                    pos[d].pop();
                    break;
                }
            }
        }
        return ans;
    }
};