class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        
        # 1. find the first index i, where sum(nums[:i+1]) >= sum(nums[i+1:])
        # 2. find the last index j, where sum(nums[:j+1]) >= sum(nums[j+1:])
        # 3. find the first index k, where sum(nums[:k+1]) >= sum(nums[k+1:]), k > i
        # 4. the number of valid splits is j - k + 1
        # 5. if k >= j, then the number of valid splits is 0
        # 6. if k == j + 1, then the number of valid splits is 1
        # 7. if k > j + 1, then the number of valid splits is k - j
        # 8. the number of valid splits is j - k + 1
        # 9. the number of valid splits is j - max(k, i + 1) + 1
        # 10. the number of valid splits is j - max(k, i + 1) + 1
        # 11. the number of valid splits is j - max(k, i + 1) + 1
        # 12. the number of valid splits is j - max(k, i + 1) + 1
        # 13. the number of valid splits is j - max(k, i + 1) + 1
        # 14. the number of valid splits is j - max(k, i + 1) + 1
        # 15. the number of valid splits is j - max(k, i + 1) + 1
        # 16. the number of valid splits is j - max(k, i + 1) + 1
        # 17. the number of valid splits is j - max(k, i + 1) + 1
        # 18. the number of valid splits is j - max(k, i + 1) + 1
        # 19. the number of valid splits is j - max(k, i + 1) + 1
        # 20. the number of valid splits is j - max(k, i + 1) + 1
        # 21. the number of valid splits is j -