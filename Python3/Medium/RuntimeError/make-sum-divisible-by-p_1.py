class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        
        # 1. Find the sum of the array
        # 2. Find the remainder of the sum
        # 3. Find the target remainder
        # 4. Find the smallest subarray that has the target remainder
        # 5. Return the length of the smallest subarray
        # 6. If no subarray found, return -1
        # 7. If the entire array is divisible by p, return 0
        # 8. If the remainder is 0, return 0
        # 9. If the remainder is not 0, and the entire array is not divisible by p, return -1
        # 10. If the length of the array is 1 and the remainder is not 0, return -1
        # 11. If the length of the array is 1 and the remainder is 0, return 0
        # 12. If the length of the array is 2 and the remainder is not 0, return -1
        # 13. If the length of the array is 2 and the remainder is 0, return 0
        # 14. If the length of the array is 3 and the remainder is not 0, return -1
        # 15. If the length of the array is 3 and the remainder is 0, return 0
        # 16. If the length of the array is 4 and the remainder is not 0, return -1
        # 17. If the length of the array is 4 and the remainder is 0, return 0
        # 18. If the length of the array is 5 and the remainder is not 0, return -1
        # 19. If the length of the array is 5 and the remainder is 0, return 0
        # 20. If the length of the array is 6 and the remainder is not 0, return -1
        # 21. If the length of the array is 6 and the remainder is 0, return 0
        # 22. If the length of the array is 7 and the remainder is not 0, return -1
        # 23. If the length of the array is 7 and the remainder is 0, return 0
        #