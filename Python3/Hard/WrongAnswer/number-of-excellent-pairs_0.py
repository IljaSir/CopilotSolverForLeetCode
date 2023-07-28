class Solution:
    def countExcellentPairs(self, nums: List[int], k: int) -> int:
        
        count = 0
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if bin(nums[i] | nums[j]).count('1') + bin(nums[i] & nums[j]).count('1') >= k:
                    count += 1
        return count