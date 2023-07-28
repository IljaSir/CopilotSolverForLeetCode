class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        long long result = 0;
        unordered_set<string> seen;
        for (int i = 0; i < ideas.size(); ++i) {
            for (int j = i + 1; j < ideas.size(); ++j) {
                string newIdea = ideas[j];
                newIdea[0] = ideas[i][0];
                string newIdea2 = ideas[i];
                newIdea2[0] = ideas[j][0];
                if (seen.find(newIdea) == seen.end() && seen.find(newIdea2) == seen.end()) {
                    result++;
                }
            }
            seen.insert(ideas[i]);
        }
        return result;
    }
};