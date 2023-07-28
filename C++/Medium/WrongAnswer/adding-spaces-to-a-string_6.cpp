class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        
        string result;
        int n = s.size();
        int m = spaces.size();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            result += s[i++];
            if (i == spaces[j]) {
                result += " ";
                ++j;
            }
        }
        while (i < n) {
            result += s[i++];
        }
        return result;
    }
};