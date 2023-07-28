class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        from collections import Counter
        c1 = Counter(nums1)
        c2 = Counter(nums2)
        c3 = c1 & c2
        result = []
        for k, v in c3.items():
            result.extend([k] * v)
        return result