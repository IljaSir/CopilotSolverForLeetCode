class Solution {
public:
    string reversePrefix(string word, char ch) {
        
        string ans = "";
        int index = word.find(ch);
        if (index == string::npos) {
            return word;
        }
        for (int i = index; i >= 0; i--) {
            ans += word[i];
        }
        for (int i = index + 1; i < word.size(); i++) {
            ans += word[i];
        }
        return ans;
    }
};