class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        
        # Solution 1: self
        # Time  complexity: O(N * M)
        # Space complexity: O(N * M)
        # N = len(words)
        # M = len(words[0])
        # res = []
        # for i in range(0, M):
        #     if all(words[0][i] in word for word in words[1:]):
        #         res.append(words[0][i])
        #         words = [word.replace(words[0][i], '', 1) for word in words]
        # return res

        # Solution 2: self
        # Time  complexity: O(N * M)
        # Space complexity: O(N * M)
        # N = len(words)
        # M = len(words[0])
        # res = []
        # for i in range(0, M):
        #     if all(words[0][i] in word for word in words):
        #         res.append(words[0][i])
        #         words = [word.replace(words[0][i], '', 1) for word in words]
        # return res

        # Solution 3: self
        # Time  complexity: O(N * M)
        # Space complexity: O(N * M)
        # N = len(words)
        # M = len(words[0])
        # res = []
        # for i in range(0, M):
        #     if all(words[0][i] in word for word in words):
        #         res.append(words[0][i])
        #         words = [word.replace(words[0][i], '', 1) for word in words if word != '']
        # return res

        # Solution 4: self
        # Time  complexity: O(N * M)
        # Space complexity: O(N * M)
        # N = len(words)
        # M = len(words[0])
        # res = []
        # for i in range(0, M):
        #     if all(words[0][i] in word for word in words):
        #         res.append(words[0][i])
        #         words = [word.replace(words[0][i], '', 1) for word in words if word != '']
        # return res

        # Solution 5: self
        # Time  complexity: O(N