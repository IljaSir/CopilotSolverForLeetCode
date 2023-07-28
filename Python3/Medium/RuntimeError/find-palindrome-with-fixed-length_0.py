class Solution:
    def kthPalindrome(self, queries: List[int], intLength: int) -> List[int]:
        
        # The first few palindromes of length 3 are:
        # 101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
        # The 90^th palindrome of length 3 is 999.
        # The first six palindromes of length 4 are:
        # 1001, 1111, 1221, 1331, 1441, and 1551.
        # 1 <= intLength <= 15
        # 1 <= queries.length <= 5 * 10^4
        # 1 <= queries[i] <= 10^9
        # palindromes cannot have leading zeros.
        # 1 <= queries[i] <= 10^9
        # 1 <= intLength <= 15
        # 1 <= queries.length <= 5 * 10^4