class Solution:
    def countVowelStrings(self, n: int) -> int:
        
        def get_count(n, i):
            if n == 0:
                return 1
            if i >= 5:
                return 0
            return get_count(n - 1, i) + get_count(n, i + 1)
        return get_count(n, 0)