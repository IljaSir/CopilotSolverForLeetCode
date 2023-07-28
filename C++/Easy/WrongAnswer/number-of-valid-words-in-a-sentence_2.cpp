class Solution {
public:
    int countValidWords(string sentence) {
        
        int n = sentence.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (sentence[i] == ' ') continue;
            if (sentence[i] == '-' || sentence[i] == '.' || sentence[i] == ',') {
                if (i == n - 1 || sentence[i + 1] == ' ') return 0;
                continue;
            }
            if (isdigit(sentence[i])) return 0;
            ++cnt;
            while (i + 1 < n && sentence[i + 1] != ' ' && sentence[i + 1] != '-' && sentence[i + 1] != '.' && sentence[i + 1] != ',' && !isdigit(sentence[i + 1])) ++i;
        }
        return cnt;
    }
};