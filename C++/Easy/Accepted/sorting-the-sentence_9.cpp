class Solution {
public:
    string sortSentence(string s) {
        
        int n = s.size();
        vector<string> v(10);
        int count = 0;
        for(int i = 0; i < n; i++) {
            int j = i+1;
            while(j < n && s[j] != ' ') j++;
            int num = s[j-1] - '0';
            v[num] = s.substr(i, j-i-1);
            i = j;
        }
        string ans = "";
        for(int i = 1; i <= 9; i++) {
            if(v[i] != "") {
                ans += v[i] + " ";
            }
        }
        ans.pop_back();
        return ans;
    }
};