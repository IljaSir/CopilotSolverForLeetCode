class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        
        res = 0
        from collections import Counter
        c1 = Counter(a+b for a in nums1 for b in nums2)
        c2 = Counter(c+d for c in nums3 for d in nums4)
        for k in c1:
            res += c1[k] * c2[-k]
        return res