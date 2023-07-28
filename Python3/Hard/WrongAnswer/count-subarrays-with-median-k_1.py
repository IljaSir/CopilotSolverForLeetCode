class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        
        def count(k):
            res = 0
            left = 0
            cnt = 0
            for right, n in enumerate(nums):
                if n < k:
                    cnt += 1
                while cnt > 0:
                    if nums[left] < k:
                        cnt -= 1
                    left += 1
                res += right - left + 1
            return res

        return count(k) - count(k + 1)