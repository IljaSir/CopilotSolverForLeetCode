class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        
        counts = [0] * 101
        for num in nums:
            counts[num] += 1
        pairs = 0
        for i in range(101):
            if counts[i] > 1:
                pairs += counts[i] // 2
        return [pairs, len(nums) - 2 * pairs]