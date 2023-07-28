class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        vector<vector<string>> res;
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (!dict.count(endWord)) return res;
        unordered_map<string, vector<string>> nodeNeighbors; // Neighbors for every node
        unordered_map<string, int> distance; // Distance of every node from the start node
        vector<string> solution;
        
        dict.insert(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);
        return res;
    }
};