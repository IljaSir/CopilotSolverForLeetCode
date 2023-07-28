class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        
        # Solution 1: Two pointers
        # Time  complexity: O(n)
        # Space complexity: O(1)
        # k, n = 0, len(nums)
        # for i in range(n):
        #     if nums[i] != val:
        #         nums[k] = nums[i]
        #         k += 1
        # return k

        # Solution 2: Two pointers - when elements to remove are rare
        # Time  complexity: O(n)
        # Space complexity: O(1)
        k, n = 0, len(nums)
        while k < n:
            if nums[k] == val:
                nums[k] = nums[n - 1]
                n -= 1
            else:
                k += 1
        return k

        # Solution 3: Two pointers - when elements to remove are common
        # Time  complexity: O(n)
        # Space complexity: O(1)
        # k, n = 0, len(nums)
        # while k < n:
        #     if nums[k] == val:
        #         nums[k] = nums[n - 1]
        #         n -= 1
        #     else:
        #         k += 1
        # return k

        # Solution 4: Two pointers - when elements to remove are rare
        # Time  complexity: O(n)
        # Space complexity: O(1)
        # k, n = 0, len(nums)
        # while k < n:
        #     if nums[k] == val:
        #         nums[k] = nums[n - 1]
        #         n -= 1
        #     else:
        #         k += 1
        # return k

        # Solution 5: Two pointers - when elements to remove are common
        # Time  complexity: O(n)
        # Space complexity: O(1)
        # k, n = 0, len(nums)
        # while k < n:
        #     if nums[k] == val:
        #         nums[k] = nums[n - 1]
        #         n -= 1
        #     else:
        #         k += 1
        # return k

        # Solution 6: Two pointers - when elements to remove are rare
        # Time  complexity: O(n