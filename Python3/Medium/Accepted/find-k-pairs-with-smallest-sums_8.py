class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        
        if not nums1 or not nums2 or not k:
            return []
        import heapq
        q = []
        for i in range(0, min(k, len(nums1))):
            heapq.heappush(q, (nums1[i] + nums2[0], i, 0))
        res = []
        while q and len(res) < k:
            _, i, j = heapq.heappop(q)
            res.append([nums1[i], nums2[j]])
            if j + 1 < len(nums2):
                heapq.heappush(q, (nums1[i] + nums2[j + 1], i, j + 1))
        return res