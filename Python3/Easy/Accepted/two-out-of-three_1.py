class Solution:
    def twoOutOfThree(self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        
        nums1_set = set(nums1)
        nums2_set = set(nums2)
        nums3_set = set(nums3)
        return list(nums1_set & nums2_set | nums1_set & nums3_set | nums2_set & nums3_set)