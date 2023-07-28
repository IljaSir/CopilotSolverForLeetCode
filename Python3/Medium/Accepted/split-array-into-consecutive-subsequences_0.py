class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        from collections import Counter, defaultdict
        counter = Counter(nums)
        tails = defaultdict(int)
        for num in nums:
            if counter[num] == 0:
                continue
            elif tails[num] > 0:
                tails[num] -= 1
                tails[num + 1] += 1
            elif counter[num + 1] > 0 and counter[num + 2] > 0:
                counter[num + 1] -= 1
                counter[num + 2] -= 1
                tails[num + 3] += 1
            else:
                return False
            counter[num] -= 1
        return True