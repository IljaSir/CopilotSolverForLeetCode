class Solution {
public:
    string lastSubstring(string s) {
        
        string ans = "";
        int n = s.size();
        int i = 0;
        while(i < n) {
            int j = i + 1, k = i;
            while(j < n && s[k] <= s[j]) {
                if(s[k] < s[j]) k = i;
                else ++k;
                ++j;
            }
            while(i <= k) {
                ans.push_back(s[i++]);
            }
        }
        return ans;
    }
};