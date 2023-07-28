class Solution:
    def minimumReplacement(self, nums: List[int]) -> int:
        
        # O(N) time, O(1) space
        # count the number of odd numbers
        # if the number of odd numbers is even, we can replace the odd numbers with even numbers
        # if the number of odd numbers is odd, we can replace the odd numbers with even numbers, except for the last one
        odd_count = sum([1 for n in nums if n % 2 == 1])
        return odd_count - (odd_count % 2)