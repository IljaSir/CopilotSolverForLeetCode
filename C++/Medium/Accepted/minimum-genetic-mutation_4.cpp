class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        unordered_set<string> bankSet(bank.begin(), bank.end());
        if (bankSet.find(endGene) == bankSet.end()) {
            return -1;
        }
        unordered_set<string> startSet;
        unordered_set<string> endSet;
        startSet.insert(startGene);
        endSet.insert(endGene);
        int step = 0;
        while (!startSet.empty() && !endSet.empty()) {
            if (startSet.size() > endSet.size()) {
                swap(startSet, endSet);
            }
            unordered_set<string> tmpSet;
            for (auto& s : startSet) {
                for (int i = 0; i < s.size(); ++i) {
                    string tmp = s;
                    for (char c : {'A', 'C', 'G', 'T'}) {
                        tmp[i] = c;
                        if (endSet.find(tmp) != endSet.end()) {
                            return step + 1;
                        }
                        if (bankSet.find(tmp) != bankSet.end()) {
                            bankSet.erase(tmp);
                            tmpSet.insert(tmp);
                        }
                    }
                }
            }
            swap(startSet, tmpSet);
            ++step;
        }
        return -1;
    }
};