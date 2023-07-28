class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        
        # Solution 1 - 400 ms
        """
        # merge sort
        def sort(enum):
            half = len(enum) // 2
            if half:
                left, right = sort(enum[:half]), sort(enum[half:])
                for i in range(len(enum))[::-1]:
                    if not right or left and left[-1][1] > right[-1][1]:
                        res[left[-1][0]] += len(right)
                        enum[i] = left.pop()
                    else:
                        enum[i] = right.pop()
            return enum
        res = [0] * len(nums)
        sort(list(enumerate(nums)))
        return res
        """
        # Solution 2 - 76 ms
        def mergeSort(nums):
            n = len(nums)
            if n <= 1:
                return nums, [0] * n
            m = n // 2
            left, left_count = mergeSort(nums[:m])
            right, right_count = mergeSort(nums[m:])
            i = j = n - 1
            res = []
            count = [0] * n
            while i >= 0 and j >= m:
                if left[i] > right[j]:
                    count[i] = j - m + 1
                    res.append(left[i])
                    i -= 1
                else:
                    res.append(right[j])
                    j -= 1
            while i >= 0:
                res.append(left[i])
                i -= 1
            while j >= m:
                res.append(right[j])
                j -= 1
            return res[::-1], count[:m] + count[m:]
        res, _ = mergeSort(nums)
        return res