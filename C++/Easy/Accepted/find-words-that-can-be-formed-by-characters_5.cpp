class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int res = 0;
        int c[26] = {0};
        for (char ch : chars) {
            c[ch - 'a']++;
        }
        for (string word : words) {
            int d[26] = {0};
            bool flag = true;
            for (char ch : word) {
                d[ch - 'a']++;
                if (d[ch - 'a'] > c[ch - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += word.length();
            }
        }
        return res;
    }
};