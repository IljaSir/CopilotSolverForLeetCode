class Solution:
    def minNumber(self, nums1: List[int], nums2: List[int]) -> int:
        
        nums = []
        for i in nums1:
            nums.append(i)
        for i in nums2:
            nums.append(i)
        nums.sort()
        return ''.join([str(i) for i in nums])