class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        int n = words.size();
        vector<int> mask(n);
        for (int i = 0; i < n; ++i) {
            mask[i] = 1 << (words[i][0] - 'a');
            mask[i] |= 1 << (words[i][1] - 'a');
        }
        int ans = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if ((mask[i] & mask[j]) == 0)
                    ans = max(ans, (int)words[i].size() + (int)words[j].size());
        
        vector<int> count(26);
        for (int i = 0; i < n; ++i) {
            int x = words[i][0] - 'a';
            int y = words[i][1] - 'a';
            if (x == y) {
                count[x] = max(count[x], (int)words[i].size());
            }
        }
        for (int i = 0; i < 26; ++i)
            ans = max(ans, count[i]);
        
        return ans;
    }
};