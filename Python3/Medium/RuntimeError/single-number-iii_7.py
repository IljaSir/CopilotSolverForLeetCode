class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        
        # 1 2 1 3 2 5
        # 1 1 2 2 3 5
        # 1 0 1 0 1 1
        # 1 1 1 0 0 1
        # 1 0 0 0 1 0
        # 1 0 0 1 1 0
        # 1 0 0 1 0 1
        # 1 0 0 1 1 1
        # 1 0 0 1 1 1
        # 1 0 0 1 1 0
        # 1 0 0 1 0 0
        # 1 0 0 1 0 0
        # 1 0 0 0 0 0
        # 1 0 0 0 0 1
        # 1 0 0 0 1 1
        # 1 0 0 1 1 1
        # 1 0 0 1 1 0
        # 1 0 0 1 0 0
        # 1 0 0 1 0 0
        # 1 0 0 0 0 0
        # 1 0 0 0 0 1
        # 1 0 0 0 1 1
        # 1 0 0 1 1 1
        # 1 0 0 1 1 0
        # 1 0 0 1 0 0
        # 1 0 0 1 0 0
        # 1 0 0 0 0 0
        # 1 0 0 0 0 1
        # 1 0 0 0 1 1
        # 1 0 0 1 1 1
        # 1 0 0 1 1 0
        # 1 0 0 1 0 0
        # 1 0 0 1 0 0
        # 1