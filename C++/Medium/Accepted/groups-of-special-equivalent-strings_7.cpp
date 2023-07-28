class Solution {
public:
    int numSpecialEquivGroups(vector<string>& words) {
        
        unordered_set<string> groups;
        for (auto &word: words) {
            string odd, even;
            for (int i = 0; i < word.size(); i++) {
                if (i % 2 == 0) {
                    even.push_back(word[i]);
                } else {
                    odd.push_back(word[i]);
                }
            }
            sort(odd.begin(), odd.end());
            sort(even.begin(), even.end());
            groups.insert(odd + even);
        }
        return groups.size();
    }
};