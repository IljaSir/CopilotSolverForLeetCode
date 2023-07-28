class Solution:
    def numSquarefulPerms(self, nums: List[int]) -> int:
        
        from collections import defaultdict
        from math import sqrt
        def is_square(n):
            return int(sqrt(n)) == sqrt(n)
        def dfs(num, used):
            if len(num) == len(nums):
                self.ans += 1
                return
            for i in range(len(nums)):
                if used[i] == 0:
                    if i > 0 and nums[i] == nums[i - 1] and used[i - 1] == 0:
                        continue
                    if len(num) == 0 or is_square(num[-1] + nums[i]):
                        used[i] = 1
                        num.append(nums[i])
                        dfs(num, used)
                        num.pop()
                        used[i] = 0
        nums.sort()
        self.ans = 0
        dfs([], [0] * len(nums))
        return self.ans