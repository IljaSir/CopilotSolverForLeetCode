impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut chars = sentence.chars().collect::<Vec<char>>();
        chars.sort();
        chars.dedup();
        chars.len() == 26
    }
}