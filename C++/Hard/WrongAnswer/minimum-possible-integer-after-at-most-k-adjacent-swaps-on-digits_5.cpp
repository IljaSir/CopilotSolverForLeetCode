class Solution {
public:
    string minInteger(string num, int k) {
        
        int n = num.size();
        string res = "";
        vector<int> idx(10, 0);
        for (int i = 0; i < n; ++i) idx[num[i] - '0'] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (idx[j] < i) continue;
                if (idx[j] - i <= k) {
                    res += j + '0';
                    k -= idx[j] - i;
                    idx[j] = -1;
                    break;
                }
            }
        }
        return res;
    }
};