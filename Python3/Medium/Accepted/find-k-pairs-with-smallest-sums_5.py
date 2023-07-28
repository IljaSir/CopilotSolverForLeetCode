class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        
        if not nums1 or not nums2:
            return []
        import heapq
        heap = []
        n1 = len(nums1)
        n2 = len(nums2)
        for i in range(n1):
            for j in range(n2):
                if len(heap) < k:
                    heapq.heappush(heap, (-nums1[i]-nums2[j], i, j))
                else:
                    if nums1[i]+nums2[j] < -heap[0][0]:
                        heapq.heappop(heap)
                        heapq.heappush(heap, (-nums1[i]-nums2[j], i, j))
                    else:
                        break
        ret = []
        while heap:
            _, i, j = heapq.heappop(heap)
            ret.append([nums1[i], nums2[j]])
        return ret[::-1]