class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def check(mid):
            count = 1
            total = 0
            for num in nums:
                if total + num > mid:
                    count += 1
                    total = num
                else:
                    total += num
            return count <= k
        left, right = max(nums), sum(nums)
        while left < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left