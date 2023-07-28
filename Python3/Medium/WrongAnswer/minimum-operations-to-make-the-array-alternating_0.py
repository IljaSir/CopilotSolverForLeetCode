class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        
        odd = 0
        even = 0
        for i in range(len(nums)):
            if i % 2 == 0:
                if nums[i] % 2 == 0:
                    odd += 1
            else:
                if nums[i] % 2 == 1:
                    odd += 1
        for i in range(len(nums)):
            if i % 2 == 0:
                if nums[i] % 2 == 1:
                    even += 1
            else:
                if nums[i] % 2 == 0:
                    even += 1
        return min(odd, even)