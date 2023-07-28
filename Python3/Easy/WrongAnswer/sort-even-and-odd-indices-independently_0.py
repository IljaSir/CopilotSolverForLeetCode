class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odd = sorted([nums[i] for i in range(1, len(nums), 2)], reverse=True)
        even = sorted([nums[i] for i in range(0, len(nums), 2)])
        for i in range(1, len(nums), 2):
            nums[i] = odd.pop()
        for i in range(0, len(nums), 2):
            nums[i] = even.pop()
        return nums