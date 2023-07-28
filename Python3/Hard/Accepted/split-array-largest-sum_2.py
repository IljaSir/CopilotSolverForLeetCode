class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def check(mid):
            count = 1
            cur_sum = 0
            for num in nums:
                cur_sum += num
                if cur_sum > mid:
                    cur_sum = num
                    count += 1
            return count <= k
        l, r = max(nums), sum(nums)
        while l < r:
            mid = (l+r)//2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l