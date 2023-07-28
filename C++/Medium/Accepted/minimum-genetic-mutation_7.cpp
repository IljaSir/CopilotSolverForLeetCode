class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        queue<string> q;
        unordered_set<string> visited;
        q.push(startGene);
        visited.insert(startGene);
        int level = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                string gene = q.front();
                q.pop();
                if (gene == endGene) {
                    return level;
                }
                for (string nextGene : bank) {
                    if (visited.count(nextGene)) {
                        continue;
                    }
                    int diff = 0;
                    for (int i = 0; i < gene.length(); i++) {
                        if (gene[i] != nextGene[i]) {
                            diff++;
                        }
                    }
                    if (diff == 1) {
                        q.push(nextGene);
                        visited.insert(nextGene);
                    }
                }
            }
            level++;
        }
        return -1;
    }
};