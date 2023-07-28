class Solution {
public:
    string customSortString(string order, string s) {
        
        int count[26] = {0};
        for (char c : s) {
            count[c - 'a']++;
        }
        string ans;
        for (char c : order) {
            ans += string(count[c - 'a'], c);
            count[c - 'a'] = 0;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            ans += string(count[c - 'a'], c);
        }
        return ans;
    }
};