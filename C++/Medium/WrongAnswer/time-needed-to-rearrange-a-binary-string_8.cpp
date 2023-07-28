class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        
        int count = 0;
        for (auto c : s) {
            if (c == '0') {
                count++;
            }
            else {
                count--;
            }
        }
        return abs(count);
    }
};