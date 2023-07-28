class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        
        def atMostK(k):
            left = 0
            count = collections.Counter()
            res = 0
            for right, x in enumerate(nums):
                if count[x] == 0:
                    k -= 1
                count[x] += 1
                while k < 0:
                    count[nums[left]] -= 1
                    if count[nums[left]] == 0:
                        k += 1
                    left += 1
                res += right - left + 1
            return res
        return atMostK(k) - atMostK(k - 1)