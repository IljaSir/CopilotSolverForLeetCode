class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        from collections import Counter
        c = Counter(nums)
        end = Counter()
        for x in nums:
            if not c[x]:
                continue
            c[x] -= 1
            if end[x-1] > 0:
                end[x-1] -= 1
                end[x] += 1
            elif c[x+1] and c[x+2]:
                c[x+1] -= 1
                c[x+2] -= 1
                end[x+2] += 1
            else:
                return False
        return True