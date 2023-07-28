class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        
        ransomNote = list(ransomNote)
        magazine = list(magazine)
        ransomNote.sort()
        magazine.sort()
        i = 0
        j = 0
        while i < len(ransomNote) and j < len(magazine):
            if ransomNote[i] == magazine[j]:
                i += 1
            j += 1
        return i == len(ransomNote)