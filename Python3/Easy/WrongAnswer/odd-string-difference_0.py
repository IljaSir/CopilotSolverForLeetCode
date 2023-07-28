class Solution:
    def oddString(self, words: List[str]) -> str:
        
        for word in words:
            diff = [ord(word[i]) - ord(word[i-1]) for i in range(1, len(word))]
            if diff.count(diff[0]) != len(diff):
                return word