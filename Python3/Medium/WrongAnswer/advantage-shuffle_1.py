class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        nums1.sort()
        result = []
        for num in nums2:
            i = bisect.bisect_left(nums1, num)
            if i == len(nums1):
                result.append(nums1.pop(0))
            else:
                result.append(nums1.pop(i))
        return result