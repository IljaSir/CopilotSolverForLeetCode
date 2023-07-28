class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        
        # 1st solution
        # O(n * m) time | O(n + m) space
        # where n is the length of words and m is the length of words[i]
        # res = []
        # for i in range(len(words)):
        #     for j in range(len(words[i])):
        #         if words[i][j] not in res and all(words[i][j] in word for word in words):
        #             res.append(words[i][j])
        # return res
        
        # 2nd solution
        # O(n * m) time | O(n + m) space
        # where n is the length of words and m is the length of words[i]
        res = []
        for i in range(len(words)):
            for j in range(len(words[i])):
                if words[i][j] not in res and all(words[i][j] in word for word in words):
                    res.append(words[i][j])
        return res