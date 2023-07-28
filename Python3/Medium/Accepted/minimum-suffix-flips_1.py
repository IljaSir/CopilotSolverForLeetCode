class Solution:
    def minFlips(self, target: str) -> int:
        
        res = 0
        for i in range(len(target)):
            if i == 0:
                if target[i] == '1':
                    res += 1
            else:
                if target[i] != target[i-1]:
                    res += 1
        return res