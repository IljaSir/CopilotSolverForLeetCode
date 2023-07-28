class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        
        # O(n) time, O(1) space
        result = 0
        count = 0
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                count += 1
            else:
                result += count * (count + 1) // 2
                count = 0
        result += count * (count + 1) // 2
        return result