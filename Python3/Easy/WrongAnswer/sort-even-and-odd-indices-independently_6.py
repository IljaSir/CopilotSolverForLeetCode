class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odd = [x for x in nums if x % 2 == 1]
        odd.sort(reverse=True)
        even = [x for x in nums if x % 2 == 0]
        even.sort()
        result = []
        for i in range(len(nums)):
            if i % 2 == 0:
                result.append(even.pop(0))
            else:
                result.append(odd.pop(0))
        return result