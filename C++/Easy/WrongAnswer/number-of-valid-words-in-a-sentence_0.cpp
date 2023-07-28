class Solution {
public:
    int countValidWords(string sentence) {
        
        int count = 0;
        bool valid = true;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence[i] == ' ') {
                if (valid) count++;
                valid = true;
            } else if (sentence[i] >= '0' && sentence[i] <= '9') {
                valid = false;
            } else if (sentence[i] == '-') {
                if (i == 0 || i == sentence.length() - 1 || sentence[i - 1] < 'a' || sentence[i - 1] > 'z' || sentence[i + 1] < 'a' || sentence[i + 1] > 'z') {
                    valid = false;
                }
            } else if (sentence[i] == '!' || sentence[i] == '.' || sentence[i] == ',') {
                if (i != sentence.length() - 1) {
                    valid = false;
                }
            }
        }
        if (valid) count++;
        return count;
    }
};