class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        vector<int> mask(words.size(), 0);
        for(int i = 0; i < words.size(); i++) {
            for(int j = 0; j < 2; j++) {
                mask[i] |= 1 << (words[i][j] - 'a');
            }
        }
        unordered_map<int, int> counts;
        for(int i = 0; i < words.size(); i++) {
            counts[mask[i]]++;
        }
        int res = 0;
        for(auto it = counts.begin(); it != counts.end(); it++) {
            for(auto it2 = counts.begin(); it2 != counts.end(); it2++) {
                if((it->first & it2->first) == 0) {
                    res = max(res, it->second * it2->second);
                }
            }
        }
        return res;
    }
};