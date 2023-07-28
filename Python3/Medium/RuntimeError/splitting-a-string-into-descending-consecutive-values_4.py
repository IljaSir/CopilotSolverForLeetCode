class Solution:
    def splitString(self, s: str) -> bool:
        
        if len(s) <= 1:
            return False
        else:
            for i in range(len(s)):
                if i == 0:
                    if s[i] == '0':
                        continue
                    else:
                        return self.splitStringHelper(s[i:], s[:i+1])
                else:
                    return self.splitStringHelper(s[i:], s[:i])
            return False