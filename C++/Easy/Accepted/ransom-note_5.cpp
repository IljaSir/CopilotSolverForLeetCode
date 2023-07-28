class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        
        int ransomNoteLen = ransomNote.length();
        int magazineLen = magazine.length();
        if (ransomNoteLen > magazineLen) {
            return false;
        }
        unordered_map<char, int> ransomNoteMap;
        unordered_map<char, int> magazineMap;
        for (int i = 0; i < ransomNoteLen; ++i) {
            ransomNoteMap[ransomNote[i]]++;
        }
        for (int i = 0; i < magazineLen; ++i) {
            magazineMap[magazine[i]]++;
        }
        for (auto &x : ransomNoteMap) {
            if (x.second > magazineMap[x.first]) {
                return false;
            }
        }
        return true;
    }
};