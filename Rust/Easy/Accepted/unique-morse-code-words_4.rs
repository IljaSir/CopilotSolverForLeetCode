impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let morse_code = vec![".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."];
        let mut set = std::collections::HashSet::new();
        for word in words {
            let mut morse = String::new();
            for c in word.chars() {
                morse.push_str(morse_code[(c as u8 - 'a' as u8) as usize]);
            }
            set.insert(morse);
        }
        set.len() as i32
    }
}