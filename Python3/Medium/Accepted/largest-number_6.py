class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        def compare(a, b):
            return int(b+a) - int(a+b)
        return str(int(''.join(sorted(map(str, nums), key=cmp_to_key(compare)))))