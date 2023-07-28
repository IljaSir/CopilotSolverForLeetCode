class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        unordered_set<string> bankSet(bank.begin(), bank.end());
        if (bankSet.find(endGene) == bankSet.end()) return -1;
        unordered_set<string> visited;
        visited.insert(startGene);
        queue<string> q;
        q.push(startGene);
        int step = 0;
        while (!q.empty()) {
            int sz = q.size();
            while (sz--) {
                string cur = q.front();
                q.pop();
                if (cur == endGene) return step;
                for (int i = 0; i < cur.size(); i++) {
                    char old = cur[i];
                    for (char c : {'A', 'C', 'G', 'T'}) {
                        cur[i] = c;
                        if (bankSet.find(cur) != bankSet.end() && visited.find(cur) == visited.end()) {
                            q.push(cur);
                            visited.insert(cur);
                        }
                    }
                    cur[i] = old;
                }
            }
            step++;
        }
        return -1;
    }
};