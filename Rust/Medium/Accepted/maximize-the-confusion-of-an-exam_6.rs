impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let mut max = 0;
        let mut window = 0;
        let mut t_count = 0;
        let mut f_count = 0;
        let mut left = 0;
        let mut right = 0;
        let k = k as usize;
        let mut answer_key = answer_key.as_bytes().to_vec();
        while right < answer_key.len() {
            let c = answer_key[right];
            if c == b'T' {
                t_count += 1;
            } else {
                f_count += 1;
            }
            window += 1;
            while t_count > k && f_count > k {
                let c = answer_key[left];
                if c == b'T' {
                    t_count -= 1;
                } else {
                    f_count -= 1;
                }
                window -= 1;
                left += 1;
            }
            max = max.max(window);
            right += 1;
        }
        max as i32
    }
}