class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        
        nums = [-n for n in nums]
        heapq.heapify(nums)
        for _ in range(k):
            n = heapq.heappop(nums)
            heapq.heappush(nums, -(-n // 3))
        return -sum(nums)