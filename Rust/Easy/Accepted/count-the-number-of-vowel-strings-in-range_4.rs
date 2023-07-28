impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        let vowel = vec!['a', 'e', 'i', 'o', 'u'];
        for i in left..=right {
            let word = &words[i as usize];
            if vowel.contains(&word.chars().nth(0).unwrap()) && vowel.contains(&word.chars().last().unwrap()) {
                count += 1;
            }
        }
        count
    }
}