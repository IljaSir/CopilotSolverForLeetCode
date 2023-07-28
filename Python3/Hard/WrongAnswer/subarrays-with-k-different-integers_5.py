class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        
        def atMostK(k):
            i = 0
            count = collections.Counter()
            for j, v in enumerate(nums):
                if count[v] == 0:
                    k -= 1
                count[v] += 1
                while k < 0:
                    count[nums[i]] -= 1
                    if count[nums[i]] == 0:
                        k += 1
                    i += 1
            return j - i + 1
        return atMostK(k) - atMostK(k - 1)