class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        
        # print(nums1)
        # print(nums2)
        max_distance = 0
        for index1, num1 in enumerate(nums1):
            for index2, num2 in enumerate(nums2):
                if num1 <= num2:
                    max_distance = max(max_distance, index2 - index1)
        return max_distance