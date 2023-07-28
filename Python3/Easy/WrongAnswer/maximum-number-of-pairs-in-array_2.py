class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        
        num_counts = [0] * 101
        pairs = 0
        for num in nums:
            pairs += num_counts[num]
            num_counts[num] += 1
        return [pairs, len(nums) - pairs]