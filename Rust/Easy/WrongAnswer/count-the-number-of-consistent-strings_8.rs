impl Solution {
    pub fn count_consistent_strings(allowed: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut allowed = allowed.chars().collect::<Vec<char>>();
        allowed.sort_unstable();
        for word in words.iter() {
            let mut chars = word.chars().collect::<Vec<char>>();
            chars.sort_unstable();
            let mut i = 0;
            let mut j = 0;
            while i < allowed.len() && j < chars.len() {
                if allowed[i] == chars[j] {
                    j += 1;
                }
                i += 1;
            }
            if j == chars.len() {
                res += 1;
            }
        }
        res
    }
}