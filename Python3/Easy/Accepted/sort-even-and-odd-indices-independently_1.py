class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odds = sorted(nums[1::2], reverse=True)
        evens = sorted(nums[::2])
        result = []
        for i in range(len(nums)):
            if i % 2 == 0:
                result.append(evens.pop(0))
            else:
                result.append(odds.pop(0))
        return result