class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        
        unordered_set<string> bankSet(bank.begin(), bank.end());
        if (bankSet.count(endGene) == 0) {
            return -1;
        }
        unordered_set<string> headSet{startGene};
        unordered_set<string> tailSet{endGene};
        int step = 0;
        while (!headSet.empty() && !tailSet.empty()) {
            if (headSet.size() > tailSet.size()) {
                swap(headSet, tailSet);
            }
            unordered_set<string> tempSet;
            for (const string& word : headSet) {
                for (int i = 0; i < word.length(); ++i) {
                    char ch = word[i];
                    for (int j = 0; j < 4; ++j) {
                        word[i] = "ACGT"[j];
                        if (tailSet.count(word)) {
                            return step + 1;
                        }
                        if (!bankSet.count(word)) {
                            continue;
                        }
                        bankSet.erase(word);
                        tempSet.insert(word);
                    }
                    word[i] = ch;
                }
            }
            swap(headSet, tempSet);
            ++step;
        }
        return -1;
    }
};