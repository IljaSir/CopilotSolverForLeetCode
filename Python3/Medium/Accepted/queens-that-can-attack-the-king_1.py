class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        
        res = []
        for x in [-1,0,1]:
            for y in [-1,0,1]:
                if x==y==0:
                    continue
                i,j = king[0]+x, king[1]+y
                while 0<=i<8 and 0<=j<8:
                    if [i,j] in queens:
                        res.append([i,j])
                        break
                    i,j = i+x, j+y
        return res