class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        map<string, int> s1map;
        map<string, int> s2map;
        vector<string> result;
        string word;
        stringstream ss1(s1);
        while(ss1 >> word){
            if(s1map.find(word) == s1map.end()){
                s1map[word] = 1;
            }else{
                s1map[word]++;
            }
        }
        stringstream ss2(s2);
        while(ss2 >> word){
            if(s2map.find(word) == s2map.end()){
                s2map[word] = 1;
            }else{
                s2map[word]++;
            }
        }
        for(auto it = s1map.begin(); it != s1map.end(); it++){
            if(it->second == 1 && s2map.find(it->first) == s2map.end()){
                result.push_back(it->first);
            }
        }
        for(auto it = s2map.begin(); it != s2map.end(); it++){
            if(it->second == 1 && s1map.find(it->first) == s1map.end()){
                result.push_back(it->first);
            }
        }
        return result;
    }
};