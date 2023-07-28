class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        
        odd_nums = []
        even_nums = []
        for i in range(len(nums)):
            if i % 2 == 0:
                even_nums.append(nums[i])
            else:
                odd_nums.append(nums[i])
        odd_nums.sort(reverse=True)
        even_nums.sort()
        for i in range(len(nums)):
            if i % 2 == 0:
                nums[i] = even_nums[i // 2]
            else:
                nums[i] = odd_nums[i // 2]
        return nums