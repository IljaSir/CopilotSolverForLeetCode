class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        sum_diff = 0
        max_diff = 0
        for i in range(n):
            diff = abs(nums1[i] - nums2[i])
            sum_diff += diff
            max_diff = max(max_diff, diff)
        if max_diff == 0:
            return 0
        sorted_nums1 = sorted(nums1)
        for i in range(n):
            num = nums2[i]
            if num == nums1[i]:
                continue
            j = bisect.bisect_left(sorted_nums1, num)
            if j == n:
                j -= 1
            elif j > 0 and abs(sorted_nums1[j-1]-num) < abs(sorted_nums1[j]-num):
                j -= 1
            max_diff = max(max_diff, abs(nums1[i]-num)-abs(sorted_nums1[j]-num))
        return (sum_diff - max_diff) % (10**9 + 7)