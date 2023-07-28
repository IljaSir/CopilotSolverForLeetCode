class Solution:
    def printVertically(self, s: str) -> List[str]:
        
        words = s.split()
        max_length = max(map(len, words))
        result = []
        for i in range(max_length):
            word = ""
            for word in words:
                if i < len(word):
                    word += word[i]
                else:
                    word += " "
            result.append(word)
        return result