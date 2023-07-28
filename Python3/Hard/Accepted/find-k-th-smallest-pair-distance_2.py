class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        n = len(nums)
        left, right = 0, nums[-1] - nums[0]
        while left < right:
            mid = left + (right - left) // 2
            count = 0
            j = 0
            for i in range(n):
                while j < n and nums[j] - nums[i] <= mid:
                    j += 1
                count += j - i - 1
            if count >= k:
                right = mid
            else:
                left = mid + 1
        return left