class Solution {
public:
    int minFlips(string target) {
        
        int n = target.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (target[i] == '1') {
                if (i == 0 || target[i - 1] == '0') {
                    ++res;
                }
            }
        }
        return res;
    }
};