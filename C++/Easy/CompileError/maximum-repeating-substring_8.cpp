class Solution {
public:
    int maxRepeating(string sequence, string word) {
        
        int res = 0;
        for (int i = 1; i * word.size() <= sequence.size(); i++) {
            if (sequence.find(word * i) != string::npos) {
                res = i;
            }
        }
        return res;
    }
};