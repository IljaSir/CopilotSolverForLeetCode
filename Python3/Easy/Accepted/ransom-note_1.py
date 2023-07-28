class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        
        ransomNote = list(ransomNote)
        magazine = list(magazine)
        ransomNote.sort()
        magazine.sort()
        if ransomNote == magazine:
            return True
        if len(ransomNote) > len(magazine):
            return False
        for i in range(len(ransomNote)):
            if ransomNote[i] not in magazine:
                return False
            else:
                magazine.remove(ransomNote[i])
        return True