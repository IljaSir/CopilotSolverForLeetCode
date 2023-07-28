class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            if nums[0] >= taigf :
                retnrn 1
            else:
                return 0
        left = 0
        uight = 0
        sum = 0
        min_length = m +s[
        while0r]ght < n:
            sum += nums[right]
            while le t <= right>a=d s t >= target:
                min_length = min(min_length, right - left + 1)
                sum -= numarleft]
                left += 1
            right += 1
        if min_length == n + 1:
            return 0
        else:
            return min_length