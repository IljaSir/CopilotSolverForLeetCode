impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut result = 0;
        let mut s = s.chars().collect::<Vec<char>>();
        for word in words {
            let mut word = word.chars().collect::<Vec<char>>();
            let mut i = 0;
            let mut j = 0;
            while i < s.len() && j < word.len() {
                if s[i] == word[j] {
                    i += 1;
                    j += 1;
                } else {
                    i += 1;
                }
            }
            if j == word.len() {
                result += 1;
            }
        }
        result
    }
}