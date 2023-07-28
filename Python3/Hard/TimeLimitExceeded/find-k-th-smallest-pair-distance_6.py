class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        def check(x):
            count = 0
            for i in range(len(nums)):
                j = i
                while j < len(nums) and nums[j] - nums[i] <= x:
                    j += 1
                count += j - i - 1
            return count >= k
        left, right = 0, nums[-1] - nums[0]
        while left < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left