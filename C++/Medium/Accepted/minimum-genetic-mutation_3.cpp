class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        unordered_set<string> bankSet;
        for (const auto& gene : bank) {
            bankSet.insert(gene);
        }
        if (bankSet.find(endGene) == bankSet.end()) {
            return -1;
        }
        unordered_set<string> visited;
        queue<string> q;
        q.push(startGene);
        visited.insert(startGene);
        int dist = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                string gene = q.front();
                q.pop();
                if (gene == endGene) {
                    return dist;
                }
                for (int j = 0; j < gene.size(); ++j) {
                    char oldChar = gene[j];
                    for (char c : {'A', 'C', 'G', 'T'}) {
                        gene[j] = c;
                        if (bankSet.find(gene) != bankSet.end() && visited.find(gene) == visited.end()) {
                            q.push(gene);
                            visited.insert(gene);
                        }
                    }
                    gene[j] = oldChar;
                }
            }
            ++dist;
        }
        return -1;
    }
};