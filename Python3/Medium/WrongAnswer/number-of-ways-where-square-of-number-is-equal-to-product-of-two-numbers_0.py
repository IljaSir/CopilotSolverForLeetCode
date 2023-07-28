class Solution:
    def numTriplets(self, nums1: List[int], nums2: List[int]) -> int:
        
        def get_num_of_triplets(nums1, nums2):
            count = 0
            for i in range(len(nums2) - 1):
                for j in range(i + 1, len(nums2)):
                    product = nums2[i] * nums2[j]
                    count += bisect.bisect_left(nums1, product ** 0.5) - bisect.bisect_right(nums1, product ** 0.5 - 1)
            return count
        return get_num_of_triplets(nums1, nums2) + get_num_of_triplets(nums2, nums1)