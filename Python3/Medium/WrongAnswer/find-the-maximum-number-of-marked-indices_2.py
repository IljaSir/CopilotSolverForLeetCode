class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        
        nums.sort()
        nums = list(dict.fromkeys(nums))
        n = len(nums)
        if n == 1:
            return 0
        if n == 2:
            if nums[0] * 2 <= nums[1]:
                return 2
            else:
                return 0
        nums = nums[::-1]
        ans = 0
        for i in range(n):
            for j in range(i+1, n):
                if nums[i] * 2 <= nums[j]:
                    ans += 2
                else:
                    break
        return ans