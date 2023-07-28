class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        for(auto& c : paragraph) {
            if(c == ',' || c == '!' || c == '?' || c == ';' || c == '\'' || c == '.' || c == ' ') {
                c = ' ';
            } else {
                c = tolower(c);
            }
        }
        unordered_set<string> ban(banned.begin(), banned.end());
        unordered_map<string, int> cnt;
        istringstream iss(paragraph);
        string word;
        int maxCnt = 0;
        string res;
        while(iss >> word) {
            if(ban.find(word) == ban.end()) {
                if(++cnt[word] > maxCnt) {
                    maxCnt = cnt[word];
                    res = word;
                }
            }
        }
        return res;
    }
};