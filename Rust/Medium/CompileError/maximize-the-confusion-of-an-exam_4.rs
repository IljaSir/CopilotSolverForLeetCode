impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = k;
        while j < answer_key.len() {
            if answer_key.as_bytes()[j] == 'T' as u8 {
                count += 1;
            }
            if j - i + 1 - count > k {
                if answer_key.as_bytes()[i] == 'T' as u8 {
                    count -= 1;
                }
                i += 1;
            }
            max = max.max(j - i + 1);
            j += 1;
        }
        max as i32
    }
}