class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        
        def count_1s(num):
            count = 0
            while num:
                count += 1
                num &= num - 1
            return count
        return sorted(arr, key=lambda x: (count_1s(x), x))