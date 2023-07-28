class Solution {
public:
    int balancedStringSplit(string s) {
        
        int count = 0;
        int bal = 0;
        for (char c : s) {
            bal += (c == 'L') ? 1 : -1;
            if (bal == 0)
                count++;
        }
        return count;
    }
};