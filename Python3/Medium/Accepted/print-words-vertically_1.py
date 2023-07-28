class Solution:
    def printVertically(self, s: str) -> List[str]:
        
        words = s.split(' ')
        max_len = max([len(word) for word in words])
        result = []
        for i in range(max_len):
            line = ''
            for word in words:
                if i < len(word):
                    line += word[i]
                else:
                    line += ' '
            result.append(line.rstrip())
        return result