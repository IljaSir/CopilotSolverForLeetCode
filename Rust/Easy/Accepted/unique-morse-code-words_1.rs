impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let morse = vec![
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        ];
        let mut set = std::collections::HashSet::new();
        for word in words {
            let mut code = String::new();
            for ch in word.chars() {
                code.push_str(morse[(ch as u8 - 'a' as u8) as usize]);
            }
            set.insert(code);
        }
        set.len() as i32
    }
}