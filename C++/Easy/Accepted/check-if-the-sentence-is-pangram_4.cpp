class Solution {
public:
    bool checkIfPangram(string sentence) {
        
        int count[26] = {0};
        for (auto c : sentence) {
            count[c - 'a']++;
        }
        for (auto c : count) {
            if (c == 0) {
                return false;
            }
        }
        return true;
    }
};