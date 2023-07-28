class Solution {
public:
    string sortSentence(string s) {
        
        string result = "";
        vector<string> words(10);
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s[j] != ' ') j++;
            int k = j - 1;
            while (k >= i && s[k] >= '0' && s[k] <= '9') k--;
            words[s[j - 1] - '0'] = s.substr(i, k - i + 1);
            i = j;
        }
        for (int i = 1; i < 10; i++) {
            if (words[i] != "") {
                result += words[i];
                result += " ";
            }
        }
        result.pop_back();
        return result;
    }
};