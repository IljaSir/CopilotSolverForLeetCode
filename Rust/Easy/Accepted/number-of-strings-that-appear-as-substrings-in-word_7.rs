impl Solution {
    pub fn num_of_strings(patterns: Vec<String>, word: String) -> i32 {
        
        patterns.iter().filter(|x| word.contains(x.as_str())).count() as i32
    }
}