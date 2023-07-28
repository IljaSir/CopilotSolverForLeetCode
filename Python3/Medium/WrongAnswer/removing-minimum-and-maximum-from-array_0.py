class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        
        n = len(nums)
        left = [0]*n
        right = [0]*n
        left[0] = nums[0]
        right[n-1] = nums[n-1]
        for i in range(1, n):
            left[i] = min(left[i-1], nums[i])
            right[n-i-1] = max(right[n-i], nums[n-i-1])
        ans = n
        for i in range(n):
            if i == 0:
                ans = min(ans, n-1 - bisect.bisect_left(right, nums[i]))
            elif i == n-1:
                ans = min(ans, n-1 - bisect.bisect_right(left, nums[i]))
            else:
                ans = min(ans, n-1 - bisect.bisect_left(right, nums[i]) + bisect.bisect_right(left, nums[i]))
        return ans