class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odds = sorted([n for n in nums if n % 2 != 0], reverse=True)
        evens = sorted([n for n in nums if n % 2 == 0])
        result = []
        for i in range(len(nums)):
            if i % 2 == 0:
                result.append(evens.pop(0))
            else:
                result.append(odds.pop(0))
        return result