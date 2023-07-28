impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            let word = &words[i as usize];
            let mut vowel = false;
            for c in word.chars() {
                if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                    vowel = true;
                } else {
                    vowel = false;
                    break;
                }
            }
            if vowel {
                count += 1;
            }
        }
        count
    }
}