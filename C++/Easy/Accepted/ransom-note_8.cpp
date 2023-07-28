class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        
        int m = ransomNote.size();
        int n = magazine.size();
        if(m > n) return false;
        vector<int> hash(26, 0);
        for(int i = 0; i < m; i++) {
            hash[ransomNote[i] - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            hash[magazine[i] - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(hash[i] > 0) return false;
        }
        return true;
    }
};