impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            let word = &words[i as usize];
            if word.starts_with('a') && word.ends_with('u') {
                count += 1;
            }
        }
        count
    }
}