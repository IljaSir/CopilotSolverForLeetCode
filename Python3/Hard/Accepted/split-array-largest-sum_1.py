class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def check(mid):
            total = 0
            count = 1
            for num in nums:
                total += num
                if total > mid:
                    total = num
                    count += 1
                    if count > k:
                        return False
            return True

        low = max(nums)
        high = sum(nums)
        while low < high:
            mid = low + (high - low) // 2
            if check(mid):
                high = mid
            else:
                low = mid + 1
        return low