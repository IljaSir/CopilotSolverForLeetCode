class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        
        string result = "";
        int j = 0;
        for(int i = 0; i < s.size(); i++){
            if(i == spaces[j]){
                result += " ";
                j++;
            }
            result += s[i];
        }
        return result;
    }
};