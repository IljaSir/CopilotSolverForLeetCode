impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut count = 0;
        for i in 0..word.len() {
            let mut set = std::collections::HashSet::new();
            for j in i..word.len() {
                set.insert(word.chars().nth(j).unwrap());
                if set.len() == 5 {
                    count += 1;
                }
            }
        }
        count
    }
}