class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        
        int ransomNoteChar[26] = {0};
        int magazineChar[26] = {0};
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteChar[ransomNote[i] - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            magazineChar[magazine[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ransomNoteChar[i] > magazineChar[i]) {
                return false;
            }
        }
        return true;
    }
};