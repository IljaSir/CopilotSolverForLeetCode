impl Solution {
    pub fn array_strings_are_equal(word1: Vec<String>, word2: Vec<String>) -> bool {
        
        let s1: String = word1.join("");
        let s2: String = word2.join("");
        s1 == s2
    }
}