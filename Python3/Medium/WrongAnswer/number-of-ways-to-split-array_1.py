class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        
        for i in range(1, len(nums)):
            nums[i] += nums[i - 1]
        ans = 0
        for i in range(1, len(nums) - 1):
            if nums[i] * 3 > nums[-1]:
                break
            l, r = i + 1, len(nums) - 1
            while l < r:
                mid = (l + r) // 2
                if nums[mid] - nums[i] < nums[i]:
                    l = mid + 1
                else:
                    r = mid
            ans += l - i
        return ans % (10**9 + 7)