class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        evens = sorted([x for x in nums if x % 2 == 0])
        odds = sorted([x for x in nums if x % 2 == 1], reverse=True)
        for i in range(len(nums)):
            if i % 2 == 0:
                nums[i] = evens.pop(0)
            else:
                nums[i] = odds.pop(0)
        return nums