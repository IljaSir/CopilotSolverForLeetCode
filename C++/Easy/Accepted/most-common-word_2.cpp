class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        unordered_set<string> ban(banned.begin(), banned.end());
        unordered_map<string, int> count;
        string ans;
        for (int i = 0, j = 0; i < paragraph.size(); i = j) {
            while (i < paragraph.size() && !isalpha(paragraph[i])) i++;
            j = i + 1;
            while (j < paragraph.size() && isalpha(paragraph[j])) j++;
            if (i < paragraph.size()) {
                string word = paragraph.substr(i, j - i);
                transform(word.begin(), word.end(), word.begin(), ::tolower);
                if (ban.find(word) == ban.end()) {
                    count[word]++;
                    if (ans.empty() || count[word] > count[ans]) {
                        ans = word;
                    }
                }
            }
        }
        return ans;
    }
};