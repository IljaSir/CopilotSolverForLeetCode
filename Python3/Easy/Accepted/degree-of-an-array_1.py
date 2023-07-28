class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        
        counter = collections.Counter(nums)
        degree = max(counter.values())
        return min([len(nums) - nums.index(i) - nums[::-1].index(i) for i in counter if counter[i] == degree])