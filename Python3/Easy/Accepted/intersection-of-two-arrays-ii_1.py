class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        counter = {}
        for num in nums1:
            if num in counter:
                counter[num] += 1
            else:
                counter[num] = 1
        result = []
        for num in nums2:
            if num in counter and counter[num] > 0:
                result.append(num)
                counter[num] -= 1
        return result