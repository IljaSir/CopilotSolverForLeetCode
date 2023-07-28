impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let mut morse: Vec<String> = vec![];
        for word in words {
            let mut morse_word = "".to_string();
            for c in word.chars() {
                morse_word.push_str(Solution::morse_code(c));
            }
            morse.push(morse_word);
        }
        morse.sort();
        morse.dedup();
        morse.len() as i32
    }
    fn morse_code(c: char) -> &'static str {
        match c {
            'a' => ".-",
            'b' => "-...",
            'c' => "-.-.",
            'd' => "-..",
            'e' => ".",
            'f' => "..-.",
            'g' => "--.",
            'h' => "....",
            'i' => "..",
            'j' => ".---",
            'k' => "-.-",
            'l' => ".-..",
            'm' => "--",
            'n' => "-.",
            'o' => "---",
            'p' => ".--.",
            'q' => "--.-",
            'r' => ".-.",
            's' => "...",
            't' => "-",
            'u' => "..-",
            'v' => "...-",
            'w' => ".--",
            'x' => "-..-",
            'y' => "-.--",
            'z' => "--..",
            _ => "",
        }
    }
}