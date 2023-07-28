class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        unordered_set<string> bankSet(bank.begin(), bank.end());
        if (bankSet.find(endGene) == bankSet.end()) return -1;
        unordered_set<string> visited;
        queue<string> q;
        q.push(startGene);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string cur = q.front();
                q.pop();
                if (cur == endGene) return step;
                for (int j = 0; j < cur.size(); j++) {
                    char old = cur[j];
                    for (char c : {'A', 'C', 'G', 'T'}) {
                        cur[j] = c;
                        if (bankSet.find(cur) != bankSet.end() && visited.find(cur) == visited.end()) {
                            q.push(cur);
                            visited.insert(cur);
                        }
                    }
                    cur[j] = old;
                }
            }
            step++;
        }
        return -1;
    }
};