class Solution {
public:
    int magicalString(int n) {
        
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        string s = "122";
        int idx = 2;
        while (s.size() < n) {
            s += string(s[idx] - '0', s.back() ^ 3);
            ++idx;
        }
        return count(s.begin(), s.begin() + n, '1');
    }
};