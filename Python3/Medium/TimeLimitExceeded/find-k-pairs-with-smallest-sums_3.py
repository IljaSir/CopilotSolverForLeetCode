class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        
        if not nums1 or not nums2:
            return []
        pairs = []
        for i in range(len(nums1)):
            for j in range(len(nums2)):
                pairs.append([nums1[i], nums2[j]])
        pairs.sort(key=lambda x:x[0]+x[1])
        return pairs[:k]