class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        
        string ans = "";
        int len1 = str1.length(), len2 = str2.length();
        int i = 0, j = 0;
        while(i < len1 && j < len2){
            if(str1[i] == str2[j]){
                ans += str1[i];
                i++;
                j++;
            }
            else{
                if(ans.length() > 0){
                    if(str1.substr(i) == ans && str2.substr(j) == ans)
                        return ans;
                    else
                        return "";
                }
                else
                    return "";
            }
        }
        if(ans.length() > 0){
            if(str1.substr(i) == ans && str2.substr(j) == ans)
                return ans;
            else
                return "";
        }
        else
            return "";
    }
};