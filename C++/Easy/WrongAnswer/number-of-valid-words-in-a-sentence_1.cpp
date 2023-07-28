class Solution {
public:
    int countValidWords(string sentence) {
        
        int count = 0;
        bool valid = false;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] >= 'a' && sentence[i] <= 'z') {
                valid = true;
                continue;
            }
            if (sentence[i] == '-' && valid) {
                valid = false;
                continue;
            }
            if (sentence[i] == '!' || sentence[i] == ',' || sentence[i] == '.') {
                if (valid) {
                    count++;
                    valid = false;
                }
                continue;
            }
            if (sentence[i] == ' ' && valid) {
                count++;
                valid = false;
            }
        }
        if (valid) {
            count++;
        }
        return count;
    }
};