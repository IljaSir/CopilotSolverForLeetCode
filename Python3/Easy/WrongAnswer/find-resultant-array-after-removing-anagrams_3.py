class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        
        for i in range(1, len(words)):
            if sorted(words[i]) == sorted(words[i-1]):
                words[i] = ''
        return [word for word in words if word]