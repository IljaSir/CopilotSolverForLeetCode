impl Solution {
    pub fn num_of_strings(patterns: Vec<String>, word: String) -> i32 {
        
        let mut result = 0;
        for pattern in patterns {
            if word.contains(&pattern) {
                result += 1;
            }
        }
        result
    }
}