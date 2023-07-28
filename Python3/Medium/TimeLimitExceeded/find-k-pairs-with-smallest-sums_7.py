class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        
        # return heapq.nsmallest(k, [[a,b] for a in nums1 for b in nums2], key=sum)
        return heapq.nsmallest(k, [[a,b] for a in nums1 for b in nums2], key=lambda x: x[0] + x[1])