class Solution {
public:
    int balancedStringSplit(string s) {
        
        int count = 0;
        int ret = 0;
        for (auto c : s) {
            if (c == 'L') count++;
            else count--;
            if (count == 0) ret++;
        }
        return ret;
    }
};