class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        
        # 1. Find the first element that is out of order
        # 2. If there is no such element, return True
        # 3. If there is one, try to fix it
        # 4. If there are more than one, return False
        # 5. If there is only one, try to fix it
        # 6. If the array is fixed, return True
        # 7. If the array is not fixed, return False
        # 8. Time complexity is O(n)
        # 9. Space complexity is O(1)
        # 10. Edge cases
        # 11. [1, 5, 4, 6, 7, 10, 8, 9]
        # 12. [1, 2, 3, 4, 5, 6, 7, 8]
        # 13. [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100,