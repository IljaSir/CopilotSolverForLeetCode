class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        
        n = len(nums)
        if n == 0:
            return -1
        if sum(nums) == x:
            return n
        left = 0
        right = 0
        target = sum(nums) - x
        ans = n + 1
        total = 0
        while right < n:
            total += nums[right]
            right += 1
            while total >= target:
                if total == target:
                    ans = min(ans, n - (right - left))
                total -= nums[left]
                left += 1
        return -1 if ans == n + 1 else ans