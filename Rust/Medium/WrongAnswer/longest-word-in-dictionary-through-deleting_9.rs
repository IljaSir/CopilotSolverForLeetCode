impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut longest = String::new();
        for word in dictionary {
            if word.len() > longest.len() {
                if Solution::is_subsequence(&s, &word) {
                    longest = word;
                }
            }
        }
        longest
    }
    
    fn is_subsequence(s: &str, t: &str) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < t.len() {
            if s.chars().nth(i).unwrap() == t.chars().nth(j).unwrap() {
                j += 1;
            }
            i += 1;
        }
        j == t.len()
    }
}