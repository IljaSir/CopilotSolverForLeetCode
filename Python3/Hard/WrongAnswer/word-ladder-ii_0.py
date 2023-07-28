class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return []
        
        # Since all words are of same length.
        L = len(beginWord)
        
        # Dictionary to hold combination of words that can be formed,
        # from any given word. By changing one letter at a time.
        all_combo_dict = defaultdict(list)
        for word in wordList:
            for i in range(L):
                # Key is the generic word
                # Value is a list of words which have the same intermediate generic word.
                all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)
        
        # Queue for BFS
        queue = deque([(beginWord, 1, [beginWord])])
        # Visited to make sure we don't repeat processing same word.
        visited = {beginWord: 1}
        ans = []
        min_step = float("inf")
        while queue:
            current_word, level, path = queue.popleft()
            if level > min_step:
                break
            for i in range(L):
                # Intermediate words for current word
                intermediate_word = current_word[:i] + "*" + current_word[i+1:]
                
                # Next states are all the words which share the same intermediate state.
                for word in all_combo_dict[intermediate_word]:
                    # If at any point if we find what we are looking for
                    # i.e. the end word - we can return with the answer.
                    if word == endWord:
                        ans.append(path + [word])
                        min_step = level
                    # Otherwise, add it to the BFS Queue. Also mark it visited
                    if word not in visited:
                        visited[word] = level + 1
                        queue.append((word, level + 1, path + [word]))
        
        return ans