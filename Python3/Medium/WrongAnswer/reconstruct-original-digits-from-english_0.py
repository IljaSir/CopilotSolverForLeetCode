class Solution:
    def originalDigits(self, s: str) -> str:
        
        
        # 1. Count the number of each unique character
        # 2. Use the number of unique characters to count the number of unique words
        # 3. Use the number of unique words to count the number of unique numbers
        # 4. Use the number of unique numbers to find the answer
        # 5. Return the answer
        
        # 1. Count the number of each unique character
        unique_chars = set(s)
        char_counts = {}
        for char in unique_chars:
            char_counts[char] = s.count(char)
        
        # 2. Use the number of unique characters to count the number of unique words
        unique_words = set()
        unique_words.add("zero")
        unique_words.add("one")
        unique_words.add("two")
        unique_words.add("three")
        unique_words.add("four")
        unique_words.add("five")
        unique_words.add("six")
        unique_words.add("seven")
        unique_words.add("eight")
        unique_words.add("nine")
        word_counts = {}
        for word in unique_words:
            word_counts[word] = 0
        for char in char_counts.keys():
            for word in unique_words:
                if word.count(char) > 0:
                    word_counts[word] += char_counts[char]
        
        # 3. Use the number of unique words to count the number of unique numbers
        unique_numbers = set()
        unique_numbers.add("0")
        unique_numbers.add("1")
        unique_numbers.add("2")
        unique_numbers.add("3")
        unique_numbers.add("4")
        unique_numbers.add("5")
        unique_numbers.add("6")
        unique_numbers.add("7")
        unique_numbers.add("8")
        unique_numbers.add("9")
        number_counts = {}
        for number in unique_numbers:
            number_counts[number] = 0
        for word in word_counts.keys():
            if word == "zero":
                number_counts["0"] += word_counts[word]
            if word == "one":
                number_counts["1"] += word_counts[word]
            if word == "two":
                number_counts["2"] += word_counts[word]
            if word == "three":
                number_counts["3"] += word_counts[word]
            if word == "four":
                number_counts["4"] += word_counts[word]
            if word == "five":
                number_counts["5"]