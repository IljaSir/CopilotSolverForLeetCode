class Solution {
public:
    bool checkRecord(string s) {
        
        int absent = 0;
        int late = 0;
        for (char c: s) {
            if (c == 'A') {
                absent++;
            }
            if (c == 'L') {
                late++;
            } else {
                late = 0;
            }
            if (absent > 1 || late > 2) {
                return false;
            }
        }
        return true;
    }
};