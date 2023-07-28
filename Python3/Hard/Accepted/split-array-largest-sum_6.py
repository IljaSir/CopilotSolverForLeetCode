class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def check(mid):
            cnt = 0
            tmp = 0
            for num in nums:
                tmp += num
                if tmp > mid:
                    tmp = num
                    cnt += 1
            return cnt + 1 <= k
        l = max(nums)
        r = sum(nums)
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l