class Solution:
    def twoOutOfThree(self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        
        # 1. Get the unique values from each array
        # 2. Get the intersection of the unique values from each array
        # 3. Get the union of the unique values from each array
        # 4. Subtract the intersection from the union
        # 5. Return the result
        # 6. O(n) time
        # 7. O(n) space
        # 8. 150 ms, 14.5 MB
        return list(set(nums1) & set(nums2) | set(nums1) & set(nums3) | set(nums2) & set(nums3))