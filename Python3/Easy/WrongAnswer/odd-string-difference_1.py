class Solution:
    def oddString(self, words: List[str]) -> str:
        
        for i in range(len(words)):
            diff = []
            for j in range(len(words[i])-1):
                diff.append(ord(words[i][j+1]) - ord(words[i][j]))
            if diff.count(diff[0]) != len(diff):
                return words[i]