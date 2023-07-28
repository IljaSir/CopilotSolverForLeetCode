class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odds = sorted(nums[1::2], reverse=True)
        evens = sorted(nums[::2])
        for i in range(len(nums)):
            if i % 2 == 0:
                nums[i] = evens[i // 2]
            else:
                nums[i] = odds[i // 2]
        return nums