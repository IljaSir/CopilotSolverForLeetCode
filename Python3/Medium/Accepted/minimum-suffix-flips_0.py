class Solution:
    def minFlips(self, target: str) -> int:
        
        res = 0
        for i in range(1, len(target)):
            if target[i] != target[i - 1]:
                res += 1
        return res + (1 if target[0] == "1" else 0)