impl Solution {
    pub fn array_strings_are_equal(word1: Vec<String>, word2: Vec<String>) -> bool {
        
        let mut w1 = String::new();
        let mut w2 = String::new();
        for i in word1 {
            w1.push_str(&i);
        }
        for i in word2 {
            w2.push_str(&i);
        }
        w1 == w2
    }
}