class Solution {
public:
    int magicalString(int n) {
        
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        string s = "122";
        int i = 2;
        while (s.size() < n) {
            s += string(s[i] - '0', s.back() ^ 3);
            ++i;
        }
        return count(begin(s), begin(s) + n, '1');
    }
};