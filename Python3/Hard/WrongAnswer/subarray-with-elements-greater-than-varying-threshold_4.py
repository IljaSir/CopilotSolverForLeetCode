class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        # binary search
        l, r = 1, len(nums)
        while l < r:
            m = (l + r) // 2
            if sum([math.ceil(n / m) for n in nums]) <= threshold:
                r = m
            else:
                l = m + 1
        return l if sum([math.ceil(n / l) for n in nums]) <= threshold else -1