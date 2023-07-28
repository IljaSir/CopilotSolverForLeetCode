class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        
        ans = []
        for i in range(8):
            for j in range(8):
                if [i, j] in queens:
                    ans.append([i, j])
        return ans