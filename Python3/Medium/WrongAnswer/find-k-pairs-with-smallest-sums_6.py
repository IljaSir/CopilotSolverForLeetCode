class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        
        if not nums1 or not nums2:
            return []
        heap = []
        for i in range(len(nums1)):
            for j in range(len(nums2)):
                if i == 0 and j < k:
                    heapq.heappush(heap, (nums1[i] + nums2[j], i, j))
                elif i > 0 and j == 0:
                    heapq.heappush(heap, (nums1[i] + nums2[j], i, j))
                else:
                    break
        result = []
        while len(result) < k and heap:
            _, i, j = heapq.heappop(heap)
            result.append([nums1[i], nums2[j]])
            if j + 1 < len(nums2):
                heapq.heappush(heap, (nums1[i] + nums2[j + 1], i, j + 1))
        return result