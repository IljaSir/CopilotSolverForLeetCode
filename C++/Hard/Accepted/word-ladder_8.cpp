class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end())
            return 0;
        unordered_set<string> visited;
        queue<string> q;
        q.push(beginWord);
        int len = 1;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string cur = q.front();
                q.pop();
                if (cur == endWord)
                    return len;
                for (int j = 0; j < cur.size(); j++) {
                    char c = cur[j];
                    for (int k = 0; k < 26; k++) {
                        cur[j] = 'a' + k;
                        if (dict.find(cur) != dict.end() && visited.find(cur) == visited.end()) {
                            q.push(cur);
                            visited.insert(cur);
                        }
                    }
                    cur[j] = c;
                }
            }
            len++;
        }
        return 0;
    }
};