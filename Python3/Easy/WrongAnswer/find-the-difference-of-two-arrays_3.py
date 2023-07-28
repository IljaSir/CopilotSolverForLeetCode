class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        
        return [[x for x in nums1 if x not in nums2], [x for x in nums2 if x not in nums1]]