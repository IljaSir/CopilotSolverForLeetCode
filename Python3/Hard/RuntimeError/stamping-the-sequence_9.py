class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        # dfs + backtracking
        # Time  complexity: O((N - M) * M * M)
        # Space complexity: O(N + M)
        # N, M = len(target), len(stamp)
        # stars = [c == '*' for c in target]
        # stamp = tuple(stamp)
        # def dfs(i):
        #     if all(stars):
        #         return True
        #     if i == N:
        #         return False
        #     if stars[i]:
        #         return dfs(i + 1)
        #     for j in range(M):
        #         if target[i + j] != stamp[j] and target[i + j] != '*':
        #             break
        #     else:
        #         for j in range(M):
        #             if not stars[i + j]:
        #                 stars[i + j] = True
        #                 if dfs(i + 1):
        #                     return True
        #                 stars[i + j] = False
        #     return False
        # if not dfs(0):
        #     return []
        # ans = []
        # for i in range(N):
        #     if stars[i]:
        #         for j in range(M):
        #             if target[i + j] != '*':
        #                 ans.append(i)
        #                 break
        # return ans[::-1]

        # greedy
        # Time  complexity: O(N * M)
        # Space complexity: O(N + M)
        N, M = len(target), len(stamp)
        stars = [c == '*' for c in target]
        stamp = tuple(stamp)
        def dfs(i):
            if all(stars):
                return True
            if i == N:
                return False
            if stars[i]:
                return dfs(i + 1)
            for j in range(M):
                if target[i + j] != stamp[j] and target[i + j] != '*':
                    break
            else:
                for j in range(M):
                    stars[i + j] = True
                return True
            return False
        if not dfs(0):
            return []
        ans = []
        for i in range(N - M + 1):
            if not stars[i]:
                continue
            for j in range(M):
                if target[i + j] != '*':