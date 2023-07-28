class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odd = sorted([x for x in nums if x % 2], reverse=True)
        even = sorted([x for x in nums if not x % 2])
        for i in range(len(nums)):
            nums[i] = odd.pop() if i % 2 else even.pop()
        return nums