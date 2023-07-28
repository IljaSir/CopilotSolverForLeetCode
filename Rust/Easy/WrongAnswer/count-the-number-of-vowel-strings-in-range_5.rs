impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        let vowels = vec!['a', 'e', 'i', 'o', 'u'];
        for w in words[left as usize..=right as usize].iter() {
            let mut is_vowel_string = true;
            for c in w.chars() {
                if !vowels.contains(&c) {
                    is_vowel_string = false;
                    break;
                }
            }
            if is_vowel_string {
                count += 1;
            }
        }
        count
    }
}