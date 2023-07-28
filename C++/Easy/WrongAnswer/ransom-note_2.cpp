class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        
        int n = ransomNote.size();
        int m = magazine.size();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (ransomNote[i] == magazine[j]) {
                i++;
            }
            j++;
        }
        return i == n;
    }
};