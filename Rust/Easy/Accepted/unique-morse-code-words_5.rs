impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let morses = vec![
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..",
        ];
        let mut set = std::collections::HashSet::new();
        for word in words {
            let mut s = String::new();
            for c in word.chars() {
                s.push_str(morses[(c as u8 - b'a') as usize]);
            }
            set.insert(s);
        }
        set.len() as i32
    }
}