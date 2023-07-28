class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        
        count = 0
        d = {}
        for i in nums:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        for key, value in d.items():
            if value > 1:
                count += value // 2
        return [count, len(nums) - count * 2]