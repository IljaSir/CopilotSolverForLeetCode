class Solution:
    def totalStrength(self, strength: List[int]) -> int:
        
        # all contiguous groups of wizards
        # total strength = min * sum
        # return the sum of all total strengths
        # brute force: O(n^2)
        # stack: O(n)
        # 1. find the min in the array
        # 2. find the sum of the array
        # 3. multiply min * sum
        # 4. add to the result
        # 5. pop the min from the array
        # 6. repeat 1-5 until the array is empty
        # return the result
        res = 0
        while strength:
            m = min(strength)
            s = sum(strength)
            res += m * s
            strength.remove(m)
        return res