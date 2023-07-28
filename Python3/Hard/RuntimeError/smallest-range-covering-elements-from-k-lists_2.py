class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        
        def add_to_heap(heap, i, j, k):
            heapq.heappush(heap, (nums[i][j], i, j))
            if j == 0:
                return True
            return False
        
        def pop_from_heap(heap, i, j, k):
            _, i, j = heapq.heappop(heap)
            if j == k - 1:
                return True
            return False
        
        k = len(nums)
        heap = []
        for i in range(k):
            add_to_heap(heap, i, 0, len(nums[i]))
        min_range = [float('-inf'), float('inf')]
        while heap:
            min_val, i, j = heapq.heappop(heap)
            if min_val - nums[i][0] < min_range[1] - min_range[0]:
                min_range = [nums[i][0], min_val]
            if pop_from_heap(heap, i, j, len(nums[i])):
                break
            add_to_heap(heap, i, j + 1, len(nums[i]))
        return min_range