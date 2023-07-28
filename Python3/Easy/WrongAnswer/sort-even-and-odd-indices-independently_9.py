class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odds = sorted([n for n in nums[1::2]], reverse=True)
        evens = sorted(nums[::2])
        for i, n in enumerate(nums[1::2]):
            nums[1::2][i] = odds[i]
        for i, n in enumerate(nums[::2]):
            nums[::2][i] = evens[i]
        return nums