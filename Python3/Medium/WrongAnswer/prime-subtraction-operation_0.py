class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        
        for i in range(len(nums)):
            if nums[i] == 1:
                return False
            for j in range(2, nums[i]):
                if nums[i] % j == 0:
                    nums[i] -= j
                    break
        return nums == sorted(nums)