class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        
        set1 = set(nums1)
        set2 = set(nums2)
        return [[x for x in set1 - set2], [x for x in set2 - set1]]