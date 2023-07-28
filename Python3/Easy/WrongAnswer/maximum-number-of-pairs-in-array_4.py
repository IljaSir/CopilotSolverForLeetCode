class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        
        count = collections.Counter(nums)
        return [sum(v*(v-1)//2 for v in count.values()), sum(v%2 for v in count.values())]