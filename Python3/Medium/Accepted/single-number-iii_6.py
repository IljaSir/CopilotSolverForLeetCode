class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        
        # return list(set(nums) - set([x for x in nums if nums.count(x) == 2]))
        d = {}
        for x in nums:
            if x not in d:
                d[x] = 1
            else:
                d[x] += 1
        return [k for k, v in d.items() if v == 1]