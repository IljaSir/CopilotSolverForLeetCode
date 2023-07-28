class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        
        def isAnagram(word1, word2):
            if len(word1) != len(word2):
                return False
            for i in range(len(word1)):
                if word1[i] not in word2:
                    return False
            return True
        i = 0
        while i < len(words) - 1:
            if isAnagram(words[i], words[i+1]):
                words.pop(i+1)
            else:
                i += 1
        return words