class Solution {
public:
    bool checkIfPangram(string sentence) {
        
        int count = 0;
        for (int i = 0; i < sentence.size(); i++) {
            int index = sentence[i] - 'a';
            if ((count & (1 << index)) == 0) {
                count |= (1 << index);
            }
        }
        return __builtin_popcount(count) == 26;
    }
};