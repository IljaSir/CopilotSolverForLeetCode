class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        

        # # Solution 1: Merge and Sort
        # for i in range(n):
        #     nums1[m+i] = nums2[i]
        # nums1.sort()

        # Solution 2: Two Pointers / Start from the beginning
        # Time  complexity: O(m + n)
        # Space complexity: O(m)
        # nums1_copy = nums1[:m]
        # nums1[:] = []

        # p1 = 0
        # p2 = 0

        # while p1 < m and p2 < n:
        #     if nums1_copy[p1] < nums2[p2]:
        #         nums1.append(nums1_copy[p1])
        #         p1 += 1
        #     else:
        #         nums1.append(nums2[p2])
        #         p2 += 1

        # if p1 < m:
        #     nums1[p1 + p2 :] = nums1_copy[p1:]
        # if p2 < n:
        #     nums1[p1 + p2 :] = nums2[p2:]

        # Solution 3: Two Pointers / Start from the end
        # Time  complexity: O(m + n)
        # Space complexity: O(1)
        p1 = m - 1
        p2 = n - 1
        p = m + n - 1

        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -= 1
            else:
                nums1[p] = nums1[p1]
                p1 -= 1
            p -= 1

        nums1[: p2 + 1] = nums2[: p2 + 1]