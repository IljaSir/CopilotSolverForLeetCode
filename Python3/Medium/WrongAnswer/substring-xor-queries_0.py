class Solution:
    def substringXorQueries(self, s: str, queries: List[List[int]]) -> List[List[int]]:
        
        result = []
        for query in queries:
            left, right = -1, -1
            for i in range(len(s)):
                for j in range(i, len(s)):
                    if i == j:
                        if int(s[i]) ^ query[0] == query[1]:
                            left = i
                            right = j
                            break
                    else:
                        if int(s[i:j+1], 2) ^ query[0] == query[1]:
                            left = i
                            right = j
                            break
                if left != -1:
                    break
            result.append([left, right])
        return result