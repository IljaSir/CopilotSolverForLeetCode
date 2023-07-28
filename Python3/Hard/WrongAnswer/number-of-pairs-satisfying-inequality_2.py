class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], diff: int) -> int:
        
        nums1, nums2 = sorted(nums1), sorted(nums2)
        ans = 0
        for i in range(len(nums1)):
            ans += bisect.bisect_right(nums2, nums1[i] + diff, i)
        return ans