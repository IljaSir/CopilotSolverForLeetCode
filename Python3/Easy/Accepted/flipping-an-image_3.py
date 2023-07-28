class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        
        ans = []
        for row in image:
            ans.append(list(map(lambda x: 1 if x == 0 else 0, row[::-1])))
        return ans