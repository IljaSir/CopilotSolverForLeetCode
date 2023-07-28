class Solution {
public:
    int divisorSubstrings(int num, int k) {
        
        string s = to_string(num);
        int res = 0;
        for (int i = 0; i <= s.size() - k; ++i) {
            if (s[i] == '0') continue;
            if (stoi(s.substr(i, k)) % num == 0) ++res;
        }
        return res;
    }
};