class Solution:
    def oddString(self, words: List[str]) -> str:
        
        for i in range(len(words)):
            a = [ord(words[i][j]) - ord(words[i][j+1]) for j in range(len(words[i])-1)]
            for j in range(len(words)):
                if i != j:
                    b = [ord(words[j][k]) - ord(words[j][k+1]) for k in range(len(words[j])-1)]
                    if a == b:
                        break
            else:
                return words[i]