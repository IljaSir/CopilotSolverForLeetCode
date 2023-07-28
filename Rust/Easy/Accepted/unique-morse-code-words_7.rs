impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let morsedict = vec![".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."];
        let mut morsewords = vec![];
        for word in words.iter() {
            let mut morseword = String::new();
            for c in word.chars() {
                morseword.push_str(morsedict[(c as u8 - b'a') as usize]);
            }
            morsewords.push(morseword);
        }
        morsewords.sort();
        morsewords.dedup();
        morsewords.len() as i32
    }
}