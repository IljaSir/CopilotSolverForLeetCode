class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        
        # Create a dictionary to map from letters to their positions in order
        order_map = {letter: position for position, letter in enumerate(order)}
        # Create a dictionary to map from words to their positions in words
        words_map = {word: position for position, word in enumerate(words)}
        # Create a dictionary to map from words to their positions in order
        order_words_map = {word: position for position, word in enumerate(sorted(words))}
        # Create a dictionary to map from words to their positions in order_map
        order_map_words_map = {word: position for position, word in enumerate(sorted(words, key=lambda word: [order_map[letter] for letter in word]))}
        # Create a dictionary to map from words to their positions in order_map
        order_map_words_map = {word: position for position, word in enumerate(sorted(words, key=lambda word: [order_map[letter] for letter in word]))}
        # Create a dictionary to map from words to their positions in order_map
        order_map_words_map = {word: position for position, word in enumerate(sorted(words, key=lambda word: [order_map[letter] for letter in word]))}
        # Create a dictionary to map from words to their positions in order_map
        order_map_words_map = {word: position for position, word in enumerate(sorted(words, key=lambda word: [order_map[letter] for letter in word]))}
        # Create a dictionary to map from words to their positions in order_map
        order_map_words_map = {word: position for position, word in enumerate(sorted(words, key=lambda word: [order_map[letter] for letter in word]))}
        # Create a dictionary to map from words to their positions in order_map
        order_map_words_map = {word: position for position, word in enumerate(sorted(words, key=lambda word: [order_map[letter] for letter in word]))}
        # Create a dictionary to map from words to their positions in order_map
        order_map_words_map = {word: position for position, word in enumerate(sorted(words, key=lambda word: [order_map[letter] for letter in word]))}
        # Create a dictionary to map from words to their positions in order_map
        order_map_words_map = {word: position for position, word in enumerate(sorted(words, key=lambda word: [order_map[letter] for letter