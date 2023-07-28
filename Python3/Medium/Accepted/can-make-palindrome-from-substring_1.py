class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        
        # number of odd count of each letter
        odd = [0]
        for i in range(len(s)):
            odd.append(odd[-1] ^ (1 << (ord(s[i]) - ord('a'))))
        return [bin(odd[r + 1] ^ odd[l]).count('1') // 2 <= k for l, r, k in queries]