class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        
        count = collections.Counter()
        for i, num in enumerate(nums):
            if i > 0 and nums[i-1] == key:
                count[num] += 1
        return count.most_common(1)[0][0]