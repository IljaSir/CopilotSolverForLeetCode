class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        
        # 0 0 1 1 0 1
        # 0 0 0 0 0 1
        # 0 0 1 1 1 1
        # 0 0 1 2 2 3
        # 0 0 1 1 1 2
        # 0 1 1 1 2 2
        # 0 1 1 2 2 2
        # 0 1 2 2 2 2
        # 0 1 2 3 3 3
        # 0 0 0 0 1 1
        # 0 0 0 0 1 1
        # 0 0 0 0 0 1