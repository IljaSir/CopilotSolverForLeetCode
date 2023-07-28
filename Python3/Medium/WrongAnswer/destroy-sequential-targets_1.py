class Solution:
    def destroyTargets(self, nums: List[int], space: int) -> int:
        
        nums.sort()
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
        def check(x):
            res = 0
            for i in range(n):
                res += (nums[i] - x) // space + 1
                if res > i + 1:
                    return False
            return True
        l, r = 1, nums[-1]
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l