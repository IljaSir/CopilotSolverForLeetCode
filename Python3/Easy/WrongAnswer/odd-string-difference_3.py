class Solution:
    def oddString(self, words: List[str]) -> str:
        
        if len(words) == 1:
            return words[0]
        if len(words) == 2:
            return words[0] if words[0] != words[1] else words[1]
        for i in range(1, len(words)):
            if words[i] == words[i-1]:
                continue
            if words[i] == words[i-2]:
                return words[i-1]
            else:
                return words[i-2]