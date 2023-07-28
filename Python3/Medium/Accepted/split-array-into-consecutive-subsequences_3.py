class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        from collections import Counter
        from collections import defaultdict
        c = Counter(nums)
        tails = defaultdict(int)
        for num in nums:
            if c[num] == 0:
                continue
            elif tails[num] > 0:
                tails[num] -= 1
                tails[num + 1] += 1
            elif c[num + 1] > 0 and c[num + 2] > 0:
                c[num + 1] -= 1
                c[num + 2] -= 1
                tails[num + 3] += 1
            else:
                return False
            c[num] -= 1
        return True