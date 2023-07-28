class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        
        m = {}
        for i in nums1:
            for j in nums2:
                if i+j in m:
                    m[i+j] += 1
                else:
                    m[i+j] = 1
        count = 0
        for i in nums3:
            for j in nums4:
                if -i-j in m:
                    count += m[-i-j]
        return count