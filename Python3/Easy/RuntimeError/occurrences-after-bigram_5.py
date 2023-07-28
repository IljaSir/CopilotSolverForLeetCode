class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        
        
        # string to list
        text = text.split()
        
        # list to array
        text = np.array(text)
        
        # find all indices of first
        first_indices = np.where(text == first)[0]
        
        # find all indices of second
        second_indices = np.where(text == second)[0]
        
        # find all indices of third
        third_indices = []
        for i in first_indices:
            for j in second_indices:
                if i + 1 == j:
                    third_indices.append(j + 1)
        
        # return list of all third
        return text[third_indices].tolist()