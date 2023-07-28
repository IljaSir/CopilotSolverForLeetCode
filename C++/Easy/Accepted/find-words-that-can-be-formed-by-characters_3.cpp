class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int a[26] = {0};
        for (auto c : chars) {
            a[c - 'a']++;
        }
        int ans = 0;
        for (auto word : words) {
            int b[26] = {0};
            bool ok = true;
            for (auto c : word) {
                b[c - 'a']++;
                if (b[c - 'a'] > a[c - 'a']) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans += word.length();
            }
        }
        return ans;
    }
};