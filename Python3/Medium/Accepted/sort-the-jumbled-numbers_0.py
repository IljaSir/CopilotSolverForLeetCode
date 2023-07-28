class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        
        return sorted(nums, key=lambda x: int(''.join(map(lambda y: str(mapping[int(y)]), str(x)))))