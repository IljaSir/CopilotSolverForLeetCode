class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end()) return 0;
        unordered_set<string> q1{beginWord};
        unordered_set<string> q2{endWord};
        int len = 1;
        while (!q1.empty() && !q2.empty()) {
            if (q1.size() > q2.size()) swap(q1, q2);
            unordered_set<string> q;
            for (string word : q1) {
                for (int i = 0; i < word.size(); ++i) {
                    char ch = word[i];
                    for (int j = 0; j < 26; ++j) {
                        word[i] = 'a' + j;
                        if (q2.find(word) != q2.end()) return len + 1;
                        if (dict.find(word) != dict.end()) {
                            q.insert(word);
                            dict.erase(word);
                        }
                    }
                    word[i] = ch;
                }
            }
            ++len;
            swap(q, q1);
        }
        return 0;
    }
};