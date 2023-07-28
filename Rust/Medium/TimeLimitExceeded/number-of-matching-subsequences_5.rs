impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for word in words {
            let mut i = 0;
            let mut j = 0;
            let mut s = s.clone();
            while i < word.len() && j < s.len() {
                if word.chars().nth(i).unwrap() == s.chars().nth(j).unwrap() {
                    i += 1;
                }
                j += 1;
            }
            if i == word.len() {
                count += 1;
            }
        }
        count
    }
}