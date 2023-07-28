class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        
        # 1. convert list to int
        # 2. add 1
        # 3. convert int to list
        return [int(i) for i in str(int(''.join([str(i) for i in digits])) + 1)]