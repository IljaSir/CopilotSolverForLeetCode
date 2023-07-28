class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def check(mid):
            count = 0
            s = 0
            for num in nums:
                s += num
                if s > mid:
                    s = num
                    count += 1
            return count + 1 <= k
        l, r = max(nums), sum(nums)
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l