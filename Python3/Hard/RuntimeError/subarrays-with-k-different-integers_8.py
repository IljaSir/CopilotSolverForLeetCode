class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        
        def atMostKDistinct(k):
            i = 0
            for j in range(len(nums)):
                if nums[j] not in d:
                    d[nums[j]] = 0
                d[nums[j]] += 1
                while len(d) > k:
                    d[nums[i]] -= 1
                    if d[nums[i]] == 0:
                        del d[nums[i]]
                    i += 1
            return j - i + 1
        d = {}
        return atMostKDistinct(k) - atMostKDistinct(k-1)