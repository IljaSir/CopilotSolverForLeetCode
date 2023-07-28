impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let mut morse = vec![];
        let mut morse_code = vec![];
        let mut morse_code_set = vec![];
        let mut morse_code_set_size = 0;
        let morse_code_map = vec![
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..",
        ];
        for word in words {
            morse.push(word);
        }
        for word in morse {
            let mut morse_code_word = String::new();
            for chr in word.chars() {
                morse_code_word.push_str(morse_code_map[(chr as u8 - 97) as usize]);
            }
            morse_code.push(morse_code_word);
        }
        for code in morse_code {
            if !morse_code_set.contains(&code) {
                morse_code_set.push(code);
            }
        }
        morse_code_set_size = morse_code_set.len() as i32;
        morse_code_set_size
    }
}