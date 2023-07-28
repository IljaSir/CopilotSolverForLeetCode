class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        # https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
        # https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
        def permuteUtil(a, l, r):
            if l == r:
                ret.append(a[:])
            else:
                for i in range(l, r + 1):
                    a[l], a[i] = a[i], a[l]
                    permuteUtil(a, l+1, r)
                    a[l], a[i] = a[i], a[l]