class Solution {
public:
    string customSortString(string order, string s) {
        
        int n = s.size();
        vector<int> cnt(26);
        for (int i=0; i<n; i++) {
            cnt[s[i]-'a']++;
        }
        string ans;
        for (int i=0; i<order.size(); i++) {
            int c = order[i]-'a';
            while (cnt[c]-- > 0) {
                ans.push_back(c+'a');
            }
        }
        for (int i=0; i<26; i++) {
            while (cnt[i]-- > 0) {
                ans.push_back(i+'a');
            }
        }
        return ans;
    }
};