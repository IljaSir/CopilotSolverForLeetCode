class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        def dfs(index, path):
            if index == len(num):
                return len(path) >= 3
            
            cur = 0
            for i in range(index, len(num)):
                if i > index and num[index] == "0":
                    break
                cur = cur * 10 + int(num[i])
                if cur > 2 ** 31 - 1:
                    break
                if len(path) < 2 or cur == path[-1] + path[-2]:
                    path.append(cur)
                    if dfs(i + 1, path):
                        return True
                    path.pop()
            return False
        
        return dfs(0, [])