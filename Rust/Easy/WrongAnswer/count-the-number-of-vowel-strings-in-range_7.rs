impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            let mut vowel = 0;
            for c in words[i as usize].chars() {
                if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                    vowel += 1;
                } else {
                    vowel = 0;
                }
            }
            count += vowel;
        }
        count
    }
}