class Solution {
public:
    bool checkIfPangram(string sentence) {
        
        vector<int> freq(26, 0);
        for (auto ch: sentence) {
            freq[ch - 'a']++;
        }
        for (auto f: freq) {
            if (f == 0) {
                return false;
            }
        }
        return true;
    }
};