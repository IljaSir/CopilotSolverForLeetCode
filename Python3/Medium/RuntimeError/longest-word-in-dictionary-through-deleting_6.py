class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        
        dictionary.sort(key=lambda x: (-len(x), x))
        for word in dictionary:
            if self.isSubsequence(word, s):
                return word
        return ""