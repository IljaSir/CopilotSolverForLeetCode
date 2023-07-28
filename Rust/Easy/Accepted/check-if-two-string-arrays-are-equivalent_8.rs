impl Solution {
    pub fn array_strings_are_equal(word1: Vec<String>, word2: Vec<String>) -> bool {
        
        let mut s1 = String::new();
        let mut s2 = String::new();
        for i in word1 {
            s1.push_str(&i);
        }
        for j in word2 {
            s2.push_str(&j);
        }
        s1 == s2
    }
}