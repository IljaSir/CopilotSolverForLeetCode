class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def can_split(target):
            count = 1
            current_sum = 0
            for num in nums:
                current_sum += num
                if current_sum > target:
                    count += 1
                    current_sum = num
            return count <= k

        l = max(nums)
        r = sum(nums)
        while l < r:
            mid = (l + r) // 2
            if can_split(mid):
                r = mid
            else:
                l = mid + 1
        return l