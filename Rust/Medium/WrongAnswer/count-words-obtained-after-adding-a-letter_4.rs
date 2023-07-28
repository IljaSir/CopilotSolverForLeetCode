impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for target in target_words {
            for start in &start_words {
                if start.len() < target.len() {
                    continue;
                }
                let mut diff = vec![0; 26];
                for c in start.chars() {
                    diff[c as usize - 'a' as usize] += 1;
                }
                for c in target.chars() {
                    diff[c as usize - 'a' as usize] -= 1;
                }
                let mut diff_count = 0;
                for i in 0..26 {
                    if diff[i] < 0 {
                        diff_count += 1;
                    }
                }
                if diff_count == 0 {
                    count += 1;
                    break;
                }
            }
        }
        count
    }
}