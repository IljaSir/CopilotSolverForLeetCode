class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        
        # The idea is to use prefix sums to find the number of plates between candles in a given substring.
        # The number of plates between candles in a substring is the number of plates in the substring minus the number of plates in the left and right substrings.
        # The number of plates in a substring is the number of plates in the prefix sum array for the substring.
        # The number of plates in the left substring is the number of plates in the prefix sum array for the left substring.
        # The number of plates in the right substring is the number of plates in the prefix sum array for the right substring.
        # The number of plates in the left substring is the number of plates in the prefix sum array for the left substring.
        # The number of plates in the right substring is the number of plates in the prefix sum array for the right substring.
        # The number of plates in the left substring is the number of plates in the prefix sum array for the left substring.
        # The number of plates in the right substring is the number of plates in the prefix sum array for the right substring.
        # The number of plates in the left substring is the number of plates in the prefix sum array for the left substring.
        # The number of plates in the right substring is