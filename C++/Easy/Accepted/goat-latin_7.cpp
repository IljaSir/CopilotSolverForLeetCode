class Solution {
public:
    string toGoatLatin(string sentence) {
        
        int i = 0;
        int j = 0;
        int n = sentence.size();
        string ans;
        int cnt = 1;
        while (i < n) {
            j = i;
            while (j < n && sentence[j] != ' ') {
                j++;
            }
            string word = sentence.substr(i, j - i);
            if (word[0] == 'a' || word[0] == 'A' || word[0] == 'e' || word[0] == 'E' || word[0] == 'i' || word[0] == 'I' || word[0] == 'o' || word[0] == 'O' || word[0] == 'u' || word[0] == 'U') {
            } else {
                word = word.substr(1) + word[0];
            }
            word += "ma";
            for (int k = 0; k < cnt; k++) {
                word += 'a';
            }
            cnt++;
            i = j + 1;
            ans += word + " ";
        }
        return ans.substr(0, ans.size() - 1);
    }
};