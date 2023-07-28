class Solution {
public:
    int numSpecialEquivGroups(vector<string>& words) {
        
        unordered_set<string> res;
        for(auto& word: words)
        {
            int odd[26] = {0};
            int even[26] = {0};
            for(int i = 0; i < word.size(); i++)
            {
                if(i % 2 == 0)
                    even[word[i] - 'a']++;
                else
                    odd[word[i] - 'a']++;
            }
            res.insert(string(even, even + 26) + string(odd, odd + 26));
        }
        return res.size();
    }
};