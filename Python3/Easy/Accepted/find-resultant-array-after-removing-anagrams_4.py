class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        
        def isAnagram(s1, s2):
            if len(s1) != len(s2):
                return False
            return sorted(s1) == sorted(s2)
        result = []
        for i, word in enumerate(words):
            if not result or not isAnagram(result[-1], word):
                result.append(word)
        return result