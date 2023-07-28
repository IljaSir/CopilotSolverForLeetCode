impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for i in left..=right {
            if words[i as usize].starts_with("a") && words[i as usize].ends_with("a") {
                count += 1;
            }
            if words[i as usize].starts_with("a") && words[i as usize].ends_with("e") {
                count += 1;
            }
            if words[i as usize].starts_with("a") && words[i as usize].ends_with("i") {
                count += 1;
            }
            if words[i as usize].starts_with("a") && words[i as usize].ends_with("o") {
                count += 1;
            }
            if words[i as usize].starts_with("a") && words[i as usize].ends_with("u") {
                count += 1;
            }
            if words[i as usize].starts_with("e") && words[i as usize].ends_with("e") {
                count += 1;
            }
            if words[i as usize].starts_with("e") && words[i as usize].ends_with("i") {
                count += 1;
            }
            if words[i as usize].starts_with("e") && words[i as usize].ends_with("o") {
                count += 1;
            }
            if words[i as usize].starts_with("e") && words[i as usize].ends_with("u") {
                count += 1;
            }
            if words[i as usize].starts_with("i") && words[i as usize].ends_with("i") {
                count += 1;
            }
            if words[i as usize].starts_with("i") && words[i as usize].ends_with("o") {
                count += 1;
            }
            if words[i as usize].starts_with("i") && words[i as usize].ends_with("u") {
                count += 1;
            }
            if words[i as usize].starts_with("o") && words[i as usize].ends_with("o") {
                count += 1;
            }
            if words[i as usize].starts_with("o") && words[i as usize].ends_with("u") {
                count += 1;
            }
            if words[i as usize].starts_with("u") && words[i as usize].ends_with("u") {
                count += 1;
            }
        }