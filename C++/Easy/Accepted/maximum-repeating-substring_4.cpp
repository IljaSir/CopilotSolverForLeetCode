class Solution {
public:
    int maxRepeating(string sequence, string word) {
        
        int r = 0;
        string t = word;
        while (sequence.find(t) != string::npos) {
            t += word;
            r++;
        }
        return r;
    }
};