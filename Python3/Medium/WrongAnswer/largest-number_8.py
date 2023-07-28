class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        def compare(s1, s2):
            return s2+s1 > s1+s2
        return str(int(''.join(sorted([str(n) for n in nums], key=cmp_to_key(compare)))))