class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        
        int count = 0;
        while (s.find("01") != string::npos) {
            count++;
            s.replace(s.find("01"), 2, "10");
        }
        return count;
    }
};