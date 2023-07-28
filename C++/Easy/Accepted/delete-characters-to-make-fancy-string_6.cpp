class Solution {
public:
    string makeFancyString(string s) {
        
        string ans;
        for(int i = 0; i < s.size(); i++){
            int count = 1;
            while(i < s.size() - 1 && s[i] == s[i+1]){
                i++;
                count++;
            }
            if(count > 2){
                ans.push_back(s[i]);
                ans.push_back(s[i]);
            }else if(count == 2){
                ans.push_back(s[i]);
                ans.push_back(s[i]);
            }else{
                ans.push_back(s[i]);
            }
        }
        return ans;
    }
};