class Solution {
public:
    string minInteger(string num, int k) {
        
        string ans;
        int n = num.size();
        vector<int> pos(10);
        for (int i = 0; i < n; ++i) pos[num[i] - '0'] = i;
        for (int i = 0; i < n; ++i) {
            for (int d = 0; d < 10; ++d) {
                if (pos[d] >= i && pos[d] - i <= k) {
                    ans += '0' + d;
                    k -= pos[d] - i;
                    for (int d1 = 0; d1 < 10; ++d1) {
                        if (pos[d1] < pos[d]) pos[d1]++;
                    }
                    pos[d] = n;
                    break;
                }
            }
        }
        return ans;
    }
};