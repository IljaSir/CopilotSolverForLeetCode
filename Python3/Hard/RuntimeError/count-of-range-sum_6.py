class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        
        # Solution 1 - Brute Force
        # Time  complexity: O(n^2)
        # Space complexity: O(1)
        # res = 0
        # for i in range(len(nums)):
        #     s = 0
        #     for j in range(i, len(nums)):
        #         s += nums[j]
        #         if lower <= s <= upper:
        #             res += 1
        # return res

        # Solution 2 - Binary Search
        # Time  complexity: O(nlogn)
        # Space complexity: O(n)
        # res = 0
        # s = 0
        # sums = [0]
        # for num in nums:
        #     s += num
        #     i = bisect.bisect_left(sums, s - upper)
        #     j = bisect.bisect_right(sums, s - lower)
        #     res += j - i
        #     bisect.insort(sums, s)
        # return res

        # Solution 3 - Merge Sort
        # Time  complexity: O(nlogn)
        # Space complexity: O(n)
        def sort(lower, upper):
            if len(sums) <= 1: return 0
            mid = len(sums) // 2
            l, r = sort(lower, upper), sort(lower, upper)
            i = j = k = 0
            while i < mid:
                while j < len(sums) and sums[j] - sums[i] < lower: j += 1
                while k < len(sums) and sums[k] - sums[i] <= upper: k += 1
                l += k - j
                i += 1
            sums[mid:] = sorted(sums[mid:])
            return l + r
        sums = [0]
        for num in nums:
            sums.append(sums[-1] + num)
        return sort(lower, upper)