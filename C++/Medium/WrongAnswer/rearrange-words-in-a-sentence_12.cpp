class Solution {
public:
    string arrangeWords(string text) {
        
        text[0] += 32;
        vector<string> words;
        string word;
        for (int i = 0; i < text.size(); ++i) {
            if (text[i] != ' ') {
                word += text[i];
            }
            else {
                words.push_back(word);
                word = "";
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](string& a, string& b){return a.size() < b.size();});
        string ans;
        for (string& word : words) {
            ans += word + ' ';
        }
        ans.pop_back();
        ans[0] -= 32;
        return ans;
    }
};