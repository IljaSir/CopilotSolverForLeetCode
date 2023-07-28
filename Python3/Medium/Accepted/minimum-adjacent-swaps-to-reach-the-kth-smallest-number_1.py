class Solution:
    def getMinSwaps(self, num: str, k: int) -> int:
        
        
        def next_permutation(nums):
            i = len(nums) - 2
            while i >= 0 and nums[i] >= nums[i + 1]:
                i -= 1
            if i >= 0:
                j = len(nums) - 1
                while j >= 0 and nums[j] <= nums[i]:
                    j -= 1
                nums[i], nums[j] = nums[j], nums[i]
            l, r = i + 1, len(nums) - 1
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
            return nums
        
        nums = list(num)
        for _ in range(k):
            nums = next_permutation(nums)
        res = 0
        for i in range(len(nums)):
            if nums[i] == num[i]:
                continue
            j = i + 1
            while nums[j] != num[i]:
                j += 1
            while j > i:
                nums[j], nums[j - 1] = nums[j - 1], nums[j]
                j -= 1
                res += 1
        return res