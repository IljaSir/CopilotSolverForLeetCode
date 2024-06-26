class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        
        # print(s)
        if len(s) < 3:
            return 0
        count = 0
        for i in range(len(s) - 2):
            if len(set(s[i:i+3])) == 3:
                count += 1
        return count