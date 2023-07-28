class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (!dict.count(endWord)) {
            return 0;
        }
        dict.erase(beginWord);
        dict.erase(endWord);
        unordered_set<string> q1{beginWord};
        unordered_set<string> q2{endWord};
        int step = 0;
        while (!q1.empty() && !q2.empty()) {
            ++step;
            if (q1.size() > q2.size()) {
                swap(q1, q2);
            }
            unordered_set<string> q;
            for (const string& word : q1) {
                string cur = word;
                for (int i = 0; i < cur.size(); ++i) {
                    char origin = cur[i];
                    for (int j = 0; j < 26; ++j) {
                        cur[i] = 'a' + j;
                        if (q2.count(cur)) {
                            return step + 1;
                        }
                        if (!dict.count(cur)) {
                            continue;
                        }
                        dict.erase(cur);
                        q.insert(cur);
                    }
                    cur[i] = origin;
                }
            }
            swap(q, q1);
        }
        return 0;
    }
};