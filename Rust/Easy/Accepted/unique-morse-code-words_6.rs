impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let morse_table = [
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--..",
        ];
        let mut morse_code_map = std::collections::HashSet::new();
        for word in words {
            let mut morse_code = String::new();
            for c in word.chars() {
                morse_code.push_str(morse_table[(c as u8 - 'a' as u8) as usize]);
            }
            morse_code_map.insert(morse_code);
        }
        morse_code_map.len() as i32
    }
}