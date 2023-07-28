impl Solution {
    pub fn array_strings_are_equal(word1: Vec<String>, word2: Vec<String>) -> bool {
        
        let mut s1 = String::new();
        let mut s2 = String::new();
        for s in word1 {
            s1.push_str(&s);
        }
        for s in word2 {
            s2.push_str(&s);
        }
        s1 == s2
    }
}