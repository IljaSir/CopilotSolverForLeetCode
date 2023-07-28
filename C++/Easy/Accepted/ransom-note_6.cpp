class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        
        int n = ransomNote.length();
        int m = magazine.length();
        if(n > m)
            return false;
        unordered_map<char, int> mp;
        for(int i = 0; i < m; i++){
            mp[magazine[i]]++;
        }
        for(int i = 0; i < n; i++){
            if(mp[ransomNote[i]] > 0){
                mp[ransomNote[i]]--;
            } else {
                return false;
            }
        }
        return true;
    }
};