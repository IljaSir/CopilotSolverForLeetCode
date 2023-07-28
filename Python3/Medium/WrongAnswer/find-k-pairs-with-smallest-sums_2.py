class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        
        n1, n2 = len(nums1), len(nums2)
        if n1 == 0 or n2 == 0 or k == 0:
            return []
        res = []
        i = j = 0
        while i < n1 and j < n2 and k > 0:
            res.append([nums1[i], nums2[j]])
            if i == n1 - 1:
                j += 1
            elif j == n2 - 1:
                i += 1
            elif nums1[i] + nums2[j + 1] <= nums1[i + 1] + nums2[j]:
                j += 1
            else:
                i += 1
            k -= 1
        return res