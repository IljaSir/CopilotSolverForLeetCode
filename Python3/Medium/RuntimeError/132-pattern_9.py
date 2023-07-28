class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        
        # 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
        # 1. find the minimum number from the left
        # 2. find the maximum number from the right
        # 3. check if the minimum number is less than the maximum number
        # 4. check if the number in the middle is greater than the minimum number and less than the maximum number
        # 5. if all of the above is true, return true
        # 6. if not, return false
        # 7. if there is no number in the middle, return false
        # 8. if there is no number that is greater than the minimum number and less than the maximum number, return false
        # 9. if there is no number that is greater than the minimum number, return false
        # 10. if there is no number that is less than the maximum number, return false
        # 11. if there is no number that is less than the minimum number, return false
        # 12. if there is no number that is greater than the maximum number, return false
        # 13. if there is no number that is greater than the minimum number and less than the maximum number, return false
        # 14. if there is no number that