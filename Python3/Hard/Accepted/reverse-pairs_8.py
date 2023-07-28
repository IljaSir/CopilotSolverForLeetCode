class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        
        # merge sort
        def merge(nums, start, mid, end):
            # count reverse pairs in a sorted array
            count = 0
            j = mid + 1
            for i in range(start, mid+1):
                while j <= end and nums[i] > 2 * nums[j]:
                    j += 1
                count += j - (mid + 1)
            nums[start:end+1] = sorted(nums[start:end+1])
            return count
        def mergeSort(nums, start, end):
            # return the number of reverse pairs
            if start >= end:
                return 0
            mid = (start + end) // 2
            count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end)
            return count + merge(nums, start, mid, end)
        return mergeSort(nums, 0, len(nums)-1)