class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def can_split(m):
            cnt, cur = 1, 0
            for n in nums:
                cur += n
                if cur > m:
                    cur = n
                    cnt += 1
            return cnt <= k
        
        left, right = max(nums), sum(nums)
        while left < right:
            mid = (left + right) // 2
            if can_split(mid):
                right = mid
            else:
                left = mid + 1
        return left