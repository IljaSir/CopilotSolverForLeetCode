impl Solution {
    pub fn num_of_strings(patterns: Vec<String>, word: String) -> i32 {
        
        let mut count = 0;
        for p in patterns {
            if word.contains(&p) { count += 1; }
        }
        count
    }
}