class Solution {
public:
    string reverseWords(string s) {
        
        string ans = "";
        int n = s.size();
        int i = n - 1;
        while(i >= 0) {
            if(s[i] == ' ') {
                i--;
                continue;
            }
            int j = i;
            while(j >= 0 && s[j] != ' ') {
                j--;
            }
            if(ans.size() == 0) {
                ans = s.substr(j + 1, i - j);
            } else {
                ans = ans + " " + s.substr(j + 1, i - j);
            }
            i = j - 1;
        }
        return ans;
    }
};