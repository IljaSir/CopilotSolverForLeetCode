class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        d = {}
        for i, v in enumerate(nums2):
            d[v] = i
        ans = []
        for v in nums1:
            i = d[v]
            while i < len(nums2):
                if nums2[i] > v:
                    ans.append(nums2[i])
                    break
                i += 1
            else:
                ans.append(-1)
        return ans