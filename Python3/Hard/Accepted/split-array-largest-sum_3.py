class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def check(x):
            cnt = 1
            s = 0
            for n in nums:
                if s + n > x:
                    cnt += 1
                    s = n
                else:
                    s += n
            return cnt <= k
        left, right = max(nums), sum(nums)
        while left < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left