class Solution {
public:
    string countAndSay(int n) {
        
        string res = "1";
        for (int i = 2; i <= n; ++i) {
            string tmp;
            int j = 0;
            while (j < res.size()) {
                int k = j;
                while (k < res.size() && res[k] == res[j]) ++k;
                tmp += to_string(k - j) + res[j];
                j = k;
            }
            res = tmp;
        }
        return res;
    }
};