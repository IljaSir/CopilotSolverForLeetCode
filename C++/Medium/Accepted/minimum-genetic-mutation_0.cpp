class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        if (startGene == endGene) return 0;
        unordered_set<string> bankSet(bank.begin(), bank.end());
        if (bankSet.find(endGene) == bankSet.end()) return -1;
        unordered_set<string> visited;
        int level = 0;
        queue<string> q;
        q.push(startGene);
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                string cur = q.front();
                q.pop();
                if (cur == endGene) return level;
                for (int i = 0; i < cur.size(); i++) {
                    for (char c : "ACGT") {
                        string next = cur;
                        next[i] = c;
                        if (bankSet.find(next) != bankSet.end() && visited.find(next) == visited.end()) {
                            q.push(next);
                            visited.insert(next);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
};