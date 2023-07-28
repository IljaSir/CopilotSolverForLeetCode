class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        
        result = []
        for i in range(len(pref)):
            result.append(pref[i] ^ result[i - 1] if i > 0 else pref[i])
        return result