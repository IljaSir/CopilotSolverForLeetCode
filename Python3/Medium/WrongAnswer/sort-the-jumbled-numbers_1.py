class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        
        mapping = {str(i): str(mapping[i]) for i in range(len(mapping))}
        return sorted(nums, key=lambda x: "".join([mapping[s] for s in str(x)]))