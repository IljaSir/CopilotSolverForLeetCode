class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        wordList = set(wordList)
        if endWord not in wordList:
            return []
        # 从头到尾的BFS
        # 从尾到头的BFS
        # 从头到尾的BFS遍历到的节点，如果在从尾到头的BFS中遍历到了，那么这个节点就是一个分岔点
        # 分别从头和尾开始BFS，当两者相遇时，就可以得到最短路径
        res = []
        def bfs(beginWord, endWord, wordList, forward, backward, path, res):
            if len(forward) == 0:
                return
            if len(forward) > len(backward):
                return bfs(endWord, beginWord, wordList, backward, forward, path, res)
            for word in forward:
                wordList.remove(word)
            for word in backward:
                wordList.remove(word)
            next_forward = set()
            while forward:
                word = forward.pop()
                if word in backward:
                    path.append(word)
                    if forward:
                        generate_path(beginWord, endWord, forward, backward, path, res, False)
                    else:
                        generate_path(beginWord, endWord, backward, forward, path, res, True)
                    path.pop()
                    continue
                for i in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        new_word = word[:i] + c + word[i+1:]
                        if new_word in wordList:
                            next_forward.add(new_word)
                            path.append(word)
                            bfs(new_word, endWord, wordList, next_forward, backward, path, res)
                            path.pop()
            return
        def generate_path(beginWord, endWord, forward, backward, path, res, reverse):
            if not forward:
                res.append(path[:])
                return
            word = forward.pop()
            path.append(word)
            if word in backward:
                generate_path(beginWord, endWord, forward, backward, path, res, reverse)
            else:
                for i in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        new_word = word[:i] + c + word[i+1:]
                        if new_word in wordList:
                            generate_path(beginWord, endWord, forward, backward, path,