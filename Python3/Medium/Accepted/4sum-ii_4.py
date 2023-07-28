class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        
        d = {}
        for num1 in nums1:
            for num2 in nums2:
                d[num1+num2] = d.get(num1+num2, 0) + 1
        res = 0
        for num3 in nums3:
            for num4 in nums4:
                res += d.get(-(num3+num4), 0)
        return res