class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        from collections import Counter, defaultdict
        c = Counter(nums)
        tails = defaultdict(int)
        for x in nums:
            if c[x] == 0:
                continue
            elif tails[x-1] > 0:
                c[x] -= 1
                tails[x-1] -= 1
                tails[x] += 1
            elif c[x+1] > 0 and c[x+2] > 0:
                c[x] -= 1
                c[x+1] -= 1
                c[x+2] -= 1
                tails[x+2] += 1
            else:
                return False
        return True