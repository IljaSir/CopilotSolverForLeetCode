class Solution:
    def makeSimilar(self, nums: List[int], target: List[int]) -> int:
        
        from collections import Counter
        c1, c2 = Counter(nums), Counter(target)
        if c1 != c2:
            return -1
        cnt = 0
        for i in range(len(nums)):
            if nums[i] != target[i]:
                cnt += 1
        return cnt // 2