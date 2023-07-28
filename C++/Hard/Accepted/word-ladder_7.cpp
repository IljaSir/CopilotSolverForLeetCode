class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) return 0;
        queue<string> q;
        q.push(beginWord);
        int ans = 0;
        while (!q.empty()) {
            ans++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                string word = q.front();
                q.pop();
                if (word == endWord) return ans;
                for (int j = 0; j < word.size(); j++) {
                    char ch = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) continue;
                        word[j] = c;
                        if (wordSet.find(word) != wordSet.end()) {
                            q.push(word);
                            wordSet.erase(word);
                        }
                    }
                    word[j] = ch;
                }
            }
        }
        return 0;
    }
};