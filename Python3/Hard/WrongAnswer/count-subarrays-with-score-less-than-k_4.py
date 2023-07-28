class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        
        # nums = [2,1,4,3,5], k = 10
        # cumsum = [0, 2, 3, 7, 10, 15]
        cumsum = [0] + list(itertools.accumulate(nums))
        # print(cumsum)
        # monoq = [(0, 0)]
        monoq = [0]
        res = 0
        for j in range(1, len(cumsum)):
            # print(monoq)
            while monoq and cumsum[j] - cumsum[monoq[0]] >= k:
                monoq.pop(0)
            res += j - monoq[0]
            while monoq and cumsum[j] <= cumsum[monoq[-1]]:
                monoq.pop()
            monoq.append(j)
        return res