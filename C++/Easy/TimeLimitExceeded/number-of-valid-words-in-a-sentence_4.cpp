class Solution {
public:
    int countValidWords(string sentence) {
        
        int n = sentence.size();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (sentence[i] == ' ') continue;
            if (sentence[i] == '-' || sentence[i] == '!' || sentence[i] == '.' || sentence[i] == ',') {
                if (i == 0 || i == n - 1 || sentence[i - 1] == ' ') return 0;
                continue;
            }
            if (!islower(sentence[i])) return 0;
            while (i < n && sentence[i] != ' ') {
                if (sentence[i] == '-' || sentence[i] == '!' || sentence[i] == '.' || sentence[i] == ',') {
                    if (i == 0 || i == n - 1 || sentence[i - 1] == ' ') return 0;
                    if (sentence[i] == '-' && islower(sentence[i - 1]) && islower(sentence[i + 1])) continue;
                    if (sentence[i] != '-' && i == n - 1) continue;
                    return 0;
                }
                if (!islower(sentence[i])) return 0;
                ++i;
            }
            ++count;
        }
        return count;
    }
};