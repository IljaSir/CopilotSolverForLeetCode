class Solution:
    def minFlips(self, target: str) -> int:
        
        # 1st solution
        # return sum([1 for i in range(len(target)) if i == 0 and target[i] == '1' or i > 0 and target[i] != target[i-1]])

        # 2nd solution
        return sum([1 for i in range(len(target)) if i == 0 and target[i] == '1' or i > 0 and target[i] != target[i-1]])