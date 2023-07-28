class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def helper(left, right, path, result):
            if left == 0 and right == 0:
                result.append(path)
                return
            if left > 0:
                helper(left - 1, right, path + '(', result)
            if right > left:
                helper(left, right - 1, path + ')', result)
        result = []
        helper(n, n, '', result)
        return result