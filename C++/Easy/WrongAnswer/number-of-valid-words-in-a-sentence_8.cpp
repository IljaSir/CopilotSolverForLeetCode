class Solution {
public:
    int countValidWords(string sentence) {
        
        int n = sentence.size();
        int res = 0;
        int i = 0;
        while (i < n) {
            bool flag = false;
            while (i < n && sentence[i] == ' ') ++i;
            while (i < n && sentence[i] != ' ') {
                if (sentence[i] == '-' && flag) return 0;
                if (sentence[i] == '-' && !flag) flag = true;
                if (sentence[i] == '.' || sentence[i] == ',' || sentence[i] == '!') {
                    if (i + 1 != n) return 0;
                }
                if (sentence[i] >= '0' && sentence[i] <= '9') return 0;
                ++i;
            }
            if (i < n) ++res;
        }
        return res;
    }
};