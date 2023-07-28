impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let morse = vec![
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        ];
        let mut result = vec![];
        for word in words {
            let mut morse_code = String::new();
            for c in word.chars() {
                morse_code.push_str(morse[(c as u8 - 97) as usize]);
            }
            if !result.contains(&morse_code) {
                result.push(morse_code);
            }
        }
        result.len() as i32
    }
}