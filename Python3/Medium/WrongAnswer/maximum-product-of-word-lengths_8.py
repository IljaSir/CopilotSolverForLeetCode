class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        # n = len(words)
        # m = len(words[0])
        # for i in range(n):
        #     for j in range(i+1,n):
        #         for k in range(m):
        #             if words[i][k] in words[j]:
        #                 break
        #         else:
        #             return max(len(words[i])*len(words[j]),self.maxProduct(words[:i]+words[i+1:j]+words[j+1:]))
        # return 0
        n = len(words)
        m = len(words[0])
        words = sorted(words,key = lambda x:len(x),reverse = True)
        for i in range(n):
            for j in range(i+1,n):
                for k in range(m):
                    if words[i][k] in words[j]:
                        break
                else:
                    return len(words[i])*len(words[j])
        return 0