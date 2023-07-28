class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def valid(mid):
            cnt, s = 1, 0
            for n in nums:
                s += n
                if s > mid:
                    cnt += 1
                    s = n
            return cnt <= k
        l, r = max(nums), sum(nums)
        while l < r:
            mid = (l + r) // 2
            if valid(mid):
                r = mid
            else:
                l = mid + 1
        return l