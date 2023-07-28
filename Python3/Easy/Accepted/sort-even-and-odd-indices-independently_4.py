class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odd = sorted(nums[1::2], reverse=True)
        even = sorted(nums[::2])
        for i in range(len(nums)):
            if i % 2 == 0:
                nums[i] = even[i // 2]
            else:
                nums[i] = odd[i // 2]
        return nums