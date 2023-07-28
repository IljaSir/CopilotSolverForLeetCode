class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        result = []
        for i in nums1:
            if i not in nums2:
                result.append(-1)
            else:
                index = nums2.index(i)
                if index == len(nums2) - 1:
                    result.append(-1)
                else:
                    found = False
                    for j in nums2[index + 1:]:
                        if j > i:
                            result.append(j)
                            found = True
                            break
                    if not found:
                        result.append(-1)
        return result