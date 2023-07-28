impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let morse: Vec<&str> = vec![".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."];
        let mut set = std::collections::HashSet::new();
        for word in words {
            let mut m = String::new();
            for c in word.chars() {
                m.push_str(morse[c as usize - 97]);
            }
            set.insert(m);
        }
        set.len() as i32
    }
}