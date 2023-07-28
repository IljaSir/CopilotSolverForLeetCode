class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        from collections import defaultdict
        d = defaultdict(list)
        for n in nums:
            if d[n-1]:
                d[n].append(d[n-1].pop())
            else:
                d[n].append(1)
        return all([not d[k] for k in d])