class Solution {
public:
    int secondHighest(string s) {
        
        vector<int> digits(10, 0);
        for (auto c : s) {
            if (c >= '0' && c <= '9') {
                digits[c - '0']++;
            }
        }
        int count = 0;
        for (int i = 9; i >= 0; --i) {
            if (digits[i] > 0) {
                count++;
                if (count == 2) {
                    return i;
                }
            }
        }
        return -1;
    }
};