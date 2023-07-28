class Solution:
    def canChoose(self, groups: List[List[int]], nums: List[int]) -> bool:
        
        i = 0
        for group in groups:
            for j in range(i, len(nums) - len(group) + 1):
                if nums[j:j+len(group)] == group:
                    i = j + len(group)
                    break
            else:
                return False
        return True