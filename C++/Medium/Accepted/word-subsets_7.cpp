class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<string> res;
        vector<int> maxCount(26,0);
        for(auto word:words2){
            vector<int> count(26,0);
            for(auto ch:word){
                count[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                maxCount[i]=max(maxCount[i],count[i]);
            }
        }
        for(auto word:words1){
            vector<int> count(26,0);
            for(auto ch:word){
                count[ch-'a']++;
            }
            bool flag=true;
            for(int i=0;i<26;i++){
                if(count[i]<maxCount[i]){
                    flag=false;
                    break;
                }
            }
            if(flag)
                res.push_back(word);
        }
        return res;
    }
};