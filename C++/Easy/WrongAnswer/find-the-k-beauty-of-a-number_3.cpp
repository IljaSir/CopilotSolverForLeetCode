class Solution {
public:
    int divisorSubstrings(int num, int k) {
        
        int res = 0;
        string s = to_string(num);
        int n = s.size();
        for (int i = 0; i <= n - k; ++i) {
            string t = s.substr(i, k);
            if (t[0] == '0') continue;
            int d = stoi(t);
            if (num % d == 0) {
                ++res;
            }
        }
        return res;
    }
};