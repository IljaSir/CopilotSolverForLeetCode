class Solution:
    def oddString(self, words: List[str]) -> str:
        
        n = len(words[0])
        for i in range(n):
            for j in range(i+1, n):
                odd = ''
                for word in words:
                    if word[i] == word[j]:
                        break
                else:
                    return odd