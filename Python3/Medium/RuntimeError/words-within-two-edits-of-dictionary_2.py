class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        
        # # Brute force: O(n^2 * m) time, O(n) space
        # ans = []
        # for query in queries:
        #     for word in dictionary:
        #         diff = 0
        #         for i in range(len(query)):
        #             if query[i] != word[i]:
        #                 diff += 1
        #                 if diff > 2:
        #                     break
        #         if diff <= 2:
        #             ans.append(query)
        #             break
        # return ans
        # # Brute force: O(n * m^2) time, O(n) space
        # ans = []
        # for query in queries:
        #     for word in dictionary:
        #         if len(query) != len(word):
        #             continue
        #         diff = 0
        #         for i in range(len(query)):
        #             if query[i] != word[i]:
        #                 diff += 1
        #                 if diff > 2:
        #                     break
        #         if diff <= 2:
        #             ans.append(query)
        #             break
        # return ans
        # # Brute force: O(n * m^2) time, O(n) space
        # ans = []
        # for query in queries:
        #     for word in dictionary:
        #         if len(query) != len(word):
        #             continue
        #         diff = 0
        #         for i in range(len(query)):
        #             if query[i] != word[i]:
        #                 diff += 1
        #                 if diff > 2:
        #                     break
        #         if diff <= 2:
        #             ans.append(query)
        #             break
        # return ans
        # # Brute force: O(n * m^2) time, O(n) space
        # ans = []
        # for query in queries:
        #     for word in dictionary:
        #         if len(query) != len(word):
        #             continue
        #         diff = 0
        #         for i in range(len(query)):
        #             if query[i] != word[i]:
        #                 diff += 1
        #                 if diff > 2:
        #                     break
        #         if diff