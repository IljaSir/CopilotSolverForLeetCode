class Solution:
    def twoOutOfThree(self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        
        d1 = {}
        d2 = {}
        d3 = {}
        for num in nums1:
            d1[num] = d1.get(num, 0) + 1
        for num in nums2:
            d2[num] = d2.get(num, 0) + 1
        for num in nums3:
            d3[num] = d3.get(num, 0) + 1
        d = {}
        for num in nums1:
            d[num] = d.get(num, 0) + 1
        for num in nums2:
            d[num] = d.get(num, 0) + 1
        for num in nums3:
            d[num] = d.get(num, 0) + 1
        return [k for k, v in d.items() if v >= 2]