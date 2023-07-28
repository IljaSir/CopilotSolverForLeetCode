class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        
        result = []
        for num1 in nums1:
            for num2 in nums2:
                result.append([num1, num2])
        result.sort(key=lambda x: x[0] + x[1])
        return result[:k]