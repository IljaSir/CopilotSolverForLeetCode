class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        
        int count = 0;
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == '1') {
                count++;
            }
        }
        return count;
    }
};