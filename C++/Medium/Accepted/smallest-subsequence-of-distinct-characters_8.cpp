class Solution {
public:
    string smallestSubsequence(string s) {
        
        string res = "";
        unordered_map<char,int> m;
        unordered_set<char> seen;
        for(auto ch:s) m[ch]++;
        for(auto ch:s){
            m[ch]--;
            if(seen.find(ch)!=seen.end()) continue;
            while(res!="" && res.back()>ch && m[res.back()]!=0){
                seen.erase(res.back());
                res.pop_back();
            }
            res.push_back(ch);
            seen.insert(ch);
        }
        return res;
    }
};