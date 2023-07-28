class Solution {
public:
    bool checkRecord(string s) {
        
        int countA = 0;
        int countL = 0;
        for (auto c : s) {
            if (c == 'A') {
                countA++;
                countL = 0;
            } else if (c == 'L') {
                countL++;
            } else {
                countL = 0;
            }
            if (countA >= 2 || countL >= 3) {
                return false;
            }
        }
        return true;
    }
};