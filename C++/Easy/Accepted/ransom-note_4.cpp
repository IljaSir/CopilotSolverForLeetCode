class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        
        int n = ransomNote.length();
        int m = magazine.length();
        if (n > m) return false;
        int freq[26] = {0};
        for (int i = 0; i < m; i++) {
            freq[magazine[i] - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (freq[ransomNote[i] - 'a'] == 0) {
                return false;
            }
            freq[ransomNote[i] - 'a']--;
        }
        return true;
    }
};