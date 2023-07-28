impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            let word = &words[i as usize];
            if word.starts_with('a') && word.ends_with('a') {
                count += 1;
            } else if word.starts_with('a') && word.ends_with('e') {
                count += 2;
            } else if word.starts_with('a') && word.ends_with('i') {
                count += 3;
            } else if word.starts_with('a') && word.ends_with('o') {
                count += 4;
            } else if word.starts_with('a') && word.ends_with('u') {
                count += 5;
            } else if word.starts_with('e') && word.ends_with('e') {
                count += 1;
            } else if word.starts_with('e') && word.ends_with('i') {
                count += 2;
            } else if word.starts_with('e') && word.ends_with('o') {
                count += 3;
            } else if word.starts_with('e') && word.ends_with('u') {
                count += 4;
            } else if word.starts_with('i') && word.ends_with('i') {
                count += 1;
            } else if word.starts_with('i') && word.ends_with('o') {
                count += 2;
            } else if word.starts_with('i') && word.ends_with('u') {
                count += 3;
            } else if word.starts_with('o') && word.ends_with('o') {
                count += 1;
            } else if word.starts_with('o') && word.ends_with('u') {
                count += 2;
            } else if word.starts_with('u') && word.ends_with('u') {
                count += 1;
            }
        }
        count
    }
}