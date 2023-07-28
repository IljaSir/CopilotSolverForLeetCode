impl Solution {
    pub fn count_consistent_strings(allowed: String, words: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut allowed = allowed.chars().collect::<Vec<char>>();
        allowed.sort();
        for word in words {
            let mut word = word.chars().collect::<Vec<char>>();
            word.sort();
            let mut i = 0;
            let mut j = 0;
            while i < word.len() && j < allowed.len() {
                if word[i] == allowed[j] {
                    i += 1;
                } else {
                    j += 1;
                }
            }
            if i == word.len() {
                count += 1;
            }
        }
        count
    }
}