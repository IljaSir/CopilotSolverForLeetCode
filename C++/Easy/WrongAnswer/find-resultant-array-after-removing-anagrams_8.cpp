class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        vector<string> res;
        for(auto s:words){
            if(res.empty()){
                res.push_back(s);
            }else{
                bool isAnagram = false;
                for(int i=0;i<res.size();i++){
                    if(isAnagramString(s,res[i])){
                        res[i] = s;
                        isAnagram = true;
                        break;
                    }
                }
                if(!isAnagram){
                    res.push_back(s);
                }
            }
        }
        return res;
    }
    bool isAnagramString(string s1, string s2){
        if(s1.length() != s2.length()){
            return false;
        }
        vector<int> count(26,0);
        for(int i=0;i<s1.length();i++){
            count[s1[i]-'a']++;
            count[s2[i]-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
};