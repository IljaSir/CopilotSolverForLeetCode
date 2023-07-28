class Solution {
public:
    int numSpecialEquivGroups(vector<string>& words) {
        
        unordered_set<string> set;
        for (string word : words) {
            string odd = "";
            string even = "";
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    even += word[i];
                } else {
                    odd += word[i];
                }
            }
            sort(odd.begin(), odd.end());
            sort(even.begin(), even.end());
            set.insert(odd + even);
        }
        return set.size();
    }
};