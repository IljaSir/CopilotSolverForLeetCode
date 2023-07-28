class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        vector<vector<string>> ans;
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) return ans;
        unordered_map<string, vector<string>> parents;
        unordered_map<string, int> distance;
        distance[beginWord] = 0;
        queue<string> q;
        q.push(beginWord);
        bool found = false;
        while (!q.empty()) {
            string word = q.front();
            q.pop();
            int d = distance[word];
            if (word == endWord) {
                found = true;
                break;
            }
            vector<string> nextWords = getNextWords(word, wordSet);
            for (auto nextWord : nextWords) {
                parents[nextWord].push_back(word);
                if (distance.find(nextWord) == distance.end()) {
                    distance[nextWord] = d + 1;
                    q.push(nextWord);
                }
            }
        }
        if (found) {
            vector<string> path = {endWord};
            getPaths(endWord, beginWord, parents, path, ans);
        }
        return ans;
    }
};