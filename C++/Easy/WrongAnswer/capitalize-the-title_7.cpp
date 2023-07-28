class Solution {
public:
    string capitalizeTitle(string title) {
        
        string res;
        int len = title.size();
        for(int i = 0; i < len; i++){
            if(i == 0){
                res.push_back(toupper(title[i]));
                continue;
            }
            if(title[i] == ' '){
                res.push_back(' ');
                res.push_back(toupper(title[i+1]));
                i++;
                continue;
            }
            res.push_back(tolower(title[i]));
        }
        return res;
    }
};