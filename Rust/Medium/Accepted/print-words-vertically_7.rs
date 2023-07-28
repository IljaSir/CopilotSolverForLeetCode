impl Solution {
    pub fn print_vertically(s: String) -> Vec<String> {
        
        let mut words: Vec<&str> = s.split(' ').collect();
        let mut max_len = 0;
        for word in &words {
            max_len = max_len.max(word.len());
        }
        let mut matrix: Vec<Vec<char>> = vec![vec![' '; words.len()]; max_len];
        for (index, word) in words.iter().enumerate() {
            for (j, c) in word.chars().enumerate() {
                matrix[j][index] = c;
            }
        }
        let mut result: Vec<String> = Vec::new();
        for line in matrix {
            let mut word = line.into_iter().collect::<String>();
            word = word.trim_end().to_string();
            result.push(word);
        }
        result
    }
}