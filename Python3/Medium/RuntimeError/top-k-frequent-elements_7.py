class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # return self.brute_force(nums, k)
        # return self.heap(nums, k)
        return self.heap_2(nums, k)