class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        for i in range(1, len(num) // 2 + 1):
            for j in range(1, (len(num) - i) // 2 + 1):
                if self.isAdditive(num, i, j):
                    return True
        return False