class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        from collections import Counter, defaultdict
        c = Counter(nums)
        tails = defaultdict(list)
        for n in nums:
            if c[n] == 0:
                continue
            c[n] -= 1
            if tails[n-1]:
                tails[n-1].pop()
                tails[n].append(n)
            elif c[n+1] and c[n+2]:
                c[n+1] -= 1
                c[n+2] -= 1
                tails[n+2].append(n+2)
            else:
                return False
        return True