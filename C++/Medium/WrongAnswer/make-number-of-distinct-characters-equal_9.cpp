class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        int n = word1.size();
        int m = word2.size();
        if(n != m)
            return false;
        int cnt = 0;
        unordered_map<char,int> mp1, mp2;
        for(int i = 0; i < n; i++){
            mp1[word1[i]]++;
            mp2[word2[i]]++;
        }
        for(auto it = mp1.begin(); it != mp1.end(); it++){
            if(mp2.find(it->first) == mp2.end())
                cnt += it->second;
            else{
                if(mp2[it->first] < it->second){
                    cnt += (it->second - mp2[it->first]);
                }
            }
        }
        for(auto it = mp2.begin(); it != mp2.end(); it++){
            if(mp1.find(it->first) == mp1.end())
                cnt += it->second;
            else{
                if(mp1[it->first] < it->second){
                    cnt += (it->second - mp1[it->first]);
                }
            }
        }
        if(cnt == 2)
            return true;
        return false;
    }
    
    bool buddyStrings(string word1, string word2) {
        int n = word1.size();
        int m = word2.size();
        if(n != m)
            return false;
        if(word1 == word2){
            unordered_map<char,int> mp;
            for(int i = 0; i < n; i++){
                mp[word1[i]]++;
            }
            for(auto it = mp.begin(); it != mp.end(); it++){
                if(it->second >= 2)
                    return true;
            }
            return false;
        }
        else{
            return isItPossible(word1, word2);
        }
    }
};