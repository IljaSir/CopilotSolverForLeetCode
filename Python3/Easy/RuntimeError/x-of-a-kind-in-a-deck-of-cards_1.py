class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        
        # deck = [1,2,3,4,4,3,2,1]
        # deck = [1,1,1,2,2,2,3,3]
        # deck = [1]
        # deck = [1,1]
        # deck = [1,1,2,2,2,2]
        # deck = [1,1,1,1,2,2,2,2,2,2]
        # deck = [1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3]
        # deck = [1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4]
        # deck = [1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,3,