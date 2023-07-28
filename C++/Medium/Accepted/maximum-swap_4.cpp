class Solution {
public:
    int maximumSwap(int num) {
        
        string s = to_string(num);
        int n = s.length();
        vector<int> idx(10, -1);
        for (int i = 0; i < n; ++i) {
            idx[s[i] - '0'] = i;
        }
        for (int i = 0; i < n; ++i) {
            for (int d = 9; d > s[i] - '0'; --d) {
                if (idx[d] > i) {
                    swap(s[i], s[idx[d]]);
                    return stoi(s);
                }
            }
        }
        return num;
    }
};