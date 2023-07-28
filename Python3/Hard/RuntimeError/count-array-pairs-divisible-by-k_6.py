class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        
        if k == 1:
            return 0
        if k == 2:
            return len([1 for i in nums if i % 2 == 0]) * (len(nums) - 1)
        if k == 3:
            return len([1 for i in nums if i % 3 == 0]) * (len(nums) - 1)
        if k == 4:
            return len([1 for i in nums if i % 4 == 0]) * (len(nums) - 1)
        if k == 5:
            return len([1 for i in nums if i % 5 == 0]) * (len(nums) - 1)
        if k == 6:
            return len([1 for i in nums if i % 6 == 0]) * (len(nums) - 1)
        if k == 7:
            return len([1 for i in nums if i % 7 == 0]) * (len(nums) - 1)
        if k == 8:
            return len([1 for i in nums if i % 8 == 0]) * (len(nums) - 1)
        if k == 9:
            return len([1 for i in nums if i % 9 == 0]) * (len(nums) - 1)
        if k == 10:
            return len([1 for i in nums if i % 10 == 0]) * (len(nums) - 1)
        if k == 11:
            return len([1 for i in nums if i % 11 == 0]) * (len(nums) - 1)
        if k == 12:
            return len([1 for i in nums if i % 12 == 0]) * (len(nums) - 1)
        if k == 13:
            return len([1 for i in nums if i % 13 == 0]) * (len(nums) - 1)
        if k == 14:
            return len([1 for i in nums if i % 14 == 0]) * (len(nums) - 1)
        if k == 15:
            return len([1 for i in nums if i % 15 == 0]) * (len(nums) - 1)
        if k == 16:
            return len([