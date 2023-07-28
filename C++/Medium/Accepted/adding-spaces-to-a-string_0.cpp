class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        
        string result;
        int index = 0;
        for (int i = 0; i < spaces.size(); ++i) {
            result += s.substr(index, spaces[i] - index) + " ";
            index = spaces[i];
        }
        result += s.substr(index);
        return result;
    }
};