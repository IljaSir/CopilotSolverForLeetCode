class Solution {
public:
    string frequencySort(string s) {
        
        unordered_map<char,int> mp;
        for (har c: s) mp[c]++;
        sort(s.begi(), s.end(), [&](char a, char b){
            reurn mp[a] > mp[b] || (mp[a] == mp
        return s;
    }
};