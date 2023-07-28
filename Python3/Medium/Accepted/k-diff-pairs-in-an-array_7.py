class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        if k < 0:
            return 0
        count = {}
        for num in nums:
            count[num] = count.get(num, 0) + 1
        res = 0
        for key, value in count.items():
            if k == 0:
                if value > 1:
                    res += 1
            else:
                if key + k in count:
                    res += 1
        return res