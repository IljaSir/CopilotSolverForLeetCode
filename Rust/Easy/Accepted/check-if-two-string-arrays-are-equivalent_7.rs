impl Solution {
    pub fn array_strings_are_equal(word1: Vec<String>, word2: Vec<String>) -> bool {
        
        let mut w1 = String::new();
        let mut w2 = String::new();
        for s in word1 {
            w1 += &s;
        }
        for s in word2 {
            w2 += &s;
        }
        w1 == w2
    }
}