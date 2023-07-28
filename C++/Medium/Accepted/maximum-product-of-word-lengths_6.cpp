class Solution {
public:
    int maxProduct(vector<string>& words) {
        
        int n = words.size();
        int ans = 0;
        vector<int> mask(n);
        for (int i = 0; i < n; i++) {
            for (char c : words[i]) {
                mask[i] |= 1 << (c - 'a');
            }
            for (int j = 0; j < i; j++) {
                if (!(mask[i] & mask[j])) {
                    ans = max(ans, int(words[i].size() * words[j].size()));
                }
            }
        }
        return ans;
    }
};