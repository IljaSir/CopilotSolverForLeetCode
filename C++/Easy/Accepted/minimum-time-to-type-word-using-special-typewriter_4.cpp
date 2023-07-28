class Solution {
public:
    int minTimeToType(string word) {
        
        int res = 0;
        char cur = 'a';
        for (auto c : word) {
            int d = abs(cur - c);
            res += min(d, 26 - d) + 1;
            cur = c;
        }
        return res;
    }
};