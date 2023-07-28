class Solution {
public:
    int numSpecialEquivGroups(vector<string>& words) {
        
        unordered_set<string> set;
        for (string& word: words) {
            string even, odd;
            for (int i = 0; i < word.size(); i++) {
                if (i % 2 == 0) {
                    even += word[i];
                } else {
                    odd += word[i];
                }
            }
            sort(even.begin(), even.end());
            sort(odd.begin(), odd.end());
            set.insert(even + odd);
        }
        return set.size();
    }
};