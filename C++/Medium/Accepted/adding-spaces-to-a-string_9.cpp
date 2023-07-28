class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        
        int n = spaces.size();
        string ans = "";
        for(int i = 0, j = 0; i < s.length(); i++){
            if( j < n && i == spaces[j]){
                ans += " ";
                j++;
            }
            ans += s[i];
        }
        return ans;
    }
};