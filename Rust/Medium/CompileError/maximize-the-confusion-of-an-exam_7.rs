impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let mut q = Vec::new();
        let mut i = 0;
        let mut j = 0;
        let mut max = 0;
        let mut count = 0;
        while i < answer_key.len() {
            if answer_key.as_bytes()[i] == b'T' {
                count += 1;
            }
            while count + k < i - j + 1 {
                if answer_key.as_bytes()[j] == b'T' {
                    count -= 1;
                }
                j += 1;
            }
            if i - j + 1 > max {
                max = i - j + 1;
            }
            i += 1;
        }
        q.clear();
        i = 0;
        j = 0;
        count = 0;
        while i < answer_key.len() {
            if answer_key.as_bytes()[i] == b'F' {
                count += 1;
            }
            while count + k < i - j + 1 {
                if answer_key.as_bytes()[j] == b'F' {
                    count -= 1;
                }
                j += 1;
            }
            if i - j + 1 > max {
                max = i - j + 1;
            }
            i += 1;
        }
        max as i32
    }
}