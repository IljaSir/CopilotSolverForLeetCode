class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        
        # divide and conquer
        # the idea is to divide the array into two halves, and then count the number of range sum in the left half and right half
        # and also count the number of range sum that cross the middle point
        # the idea is similar to merge sort, we need to merge the two sorted halves into one sorted array
        # and we can use two pointers to count the number of range sum that cross the middle point
        # time complexity: O(nlogn)
        # space complexity: O(n)
        def mergeSort(sums, lower, upper):
            n = len(sums)
            if n <= 1:
                return 0
            mid = n // 2
            count = mergeSort(sums[:mid], lower, upper) + mergeSort(sums[mid:], lower, upper)
            # count the number of range sum that cross the middle point
            # use two pointers to count the number of range sum that cross the middle point
            i = j = k = mid
            for left in sums[:mid]:
                while i < n and sums[i] - left < lower:
                    i += 1
                while j < n and sums[j] - left <= upper:
                    j += 1
                count += j - i
            # merge the two sorted halves into one sorted array
            sums[:k] = sorted(sums[:k] + sums[k:])
            return count
        n = len(nums)
        if n == 0:
            return 0
        sums = [0] * (n + 1)
        for i in range(n):
            sums[i + 1] = sums[i] + nums[i]
        return mergeSort(sums, lower, upper)