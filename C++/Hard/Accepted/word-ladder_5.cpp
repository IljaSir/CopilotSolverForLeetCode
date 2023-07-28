class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (!wordSet.count(endWord)) return 0;
        unordered_set<string> q1{beginWord};
        unordered_set<string> q2{endWord};
        int step = 1;
        int len = beginWord.length();
        while (!q1.empty() && !q2.empty()) {
            if (q1.size() > q2.size()) {
                swap(q1, q2);
            }
            unordered_set<string> q;
            for (string w : q1) {
                wordSet.erase(w);
                for (int i = 0; i < len; ++i) {
                    char ch = w[i];
                    for (int j = 'a'; j <= 'z'; ++j) {
                        w[i] = j;
                        if (q2.count(w)) return step + 1;
                        if (!wordSet.count(w)) continue;
                        wordSet.erase(w);
                        q.insert(w);
                    }
                    w[i] = ch;
                }
            }
            swap(q, q1);
            ++step;
        }
        return 0;
    }
};