class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        if len(num) < 3:
            return False
        for i in range(1, (len(num) + 1) // 2):
            for j in range(i + 1, len(num)):
                if self.isAdditiveNumberHelper(num, 0, i, j):
                    return True
        return False