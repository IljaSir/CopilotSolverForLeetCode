class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        from collections import Counter, defaultdict
        count = Counter(nums)
        tails = defaultdict(int)
        for num in nums:
            if count[num] == 0:
                continue
            count[num] -= 1
            if tails[num-1] > 0:
                tails[num-1] -= 1
                tails[num] += 1
            elif count[num+1] > 0 and count[num+2] > 0:
                count[num+1] -= 1
                count[num+2] -= 1
                tails[num+2] += 1
            else:
                return False
        return True