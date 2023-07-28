class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        unordered_set<string> bankSet(bank.begin(), bank.end());
        if (bankSet.find(endGene) == bankSet.end()) return -1;
        unordered_set<string> startSet{startGene};
        unordered_set<string> endSet{endGene};
        int step = 0;
        while (!startSet.empty() && !endSet.empty()) {
            step++;
            if (startSet.size() > endSet.size()) {
                swap(startSet, endSet);
            }
            unordered_set<string> tempSet;
            for (auto gene: startSet) {
                for (int i = 0; i < gene.size(); i++) {
                    char c = gene[i];
                    for (auto ch: vector<char>{'A', 'C', 'G', 'T'}) {
                        gene[i] = ch;
                        if (endSet.find(gene) != endSet.end()) {
                            return step;
                        }
                        if (bankSet.find(gene) != bankSet.end()) {
                            tempSet.insert(gene);
                            bankSet.erase(gene);
                        }
                    }
                    gene[i] = c;
                }
            }
            swap(startSet, tempSet);
        }
        return -1;
    }
};