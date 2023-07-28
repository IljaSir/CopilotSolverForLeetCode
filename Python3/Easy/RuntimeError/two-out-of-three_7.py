class Solution:
    def twoOutOfThree(self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        
        # nums1, nums2, nums3 = [1,1,3,2], [2,3], [3]
        # nums1, nums2, nums3 = [3,1], [2,3], [1,2]
        # nums1, nums2, nums3 = [1,2,2], [4,3,3], [5]
        # nums1, nums2, nums3 = [2,1,3,4], [1,2,3,4], [2,1,3,4]
        # nums1, nums2, nums3 = [1,1,3,2], [2,3], [3]
        # nums1, nums2, nums3 = [3,1], [2,3], [1,2]
        # nums1, nums2, nums3 = [1,2,2], [4,3,3], [5]
        # nums1, nums2, nums3 = [2,1,3,4], [1,2,3,4], [2,1,3,4]
        # nums1, nums2, nums3 = [3,3,1,2,2], [1,2,3,3,3], [2,3,3,3