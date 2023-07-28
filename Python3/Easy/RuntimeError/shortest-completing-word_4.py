class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        
        # Use a dictionary to store the number of times each character appears in the licensePlate
        # Use a dictionary to store the number of times each character appears in the words
        # Compare the two dictionaries and decide whether the word is a completing word
        # If it is a completing word, compare the length of the word with the length of the shortest completing word
        # If the length of the word is shorter, update the shortest completing word
        # Return the shortest completing word