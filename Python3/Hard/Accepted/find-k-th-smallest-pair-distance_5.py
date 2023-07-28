class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        def check(mid):
            i, cnt = 0, 0
            for j in range(len(nums)):
                while nums[j] - nums[i] > mid:
                    i += 1
                cnt += j - i
            return cnt >= k
        l, r = 0, nums[-1] - nums[0]
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l