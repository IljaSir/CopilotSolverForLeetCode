class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        int len = s.length();
        int count[26] = {0};
        int curCount = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && (s[i] - s[i-1] == 1 || s[i-1] - s[i] == 25)) {
                curCount++;
            } else {
                curCount = 1;
            }
            int index = s[i] - 'a';
            count[index] = max(count[index], curCount);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += count[i];
        }
        return ans;
    }
};