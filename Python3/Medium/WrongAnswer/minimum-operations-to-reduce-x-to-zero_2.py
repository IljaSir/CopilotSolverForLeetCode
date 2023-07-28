class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        
        n = len(nums)
        if sum(nums) == x:
            return n
        if sum(nums) < x:
            return -1
        if sum(nums) == 2*x:
            return n-1
        left = 0
        right = 0
        cur_sum = 0
        max_len = -1
        while right < n:
            cur_sum += nums[right]
            while cur_sum > x and left <= right:
                cur_sum -= nums[left]
                left += 1
            if cur_sum == x:
                max_len = max(max_len, right-left+1)
            right += 1
        return n-max_len if max_len != -1 else -1