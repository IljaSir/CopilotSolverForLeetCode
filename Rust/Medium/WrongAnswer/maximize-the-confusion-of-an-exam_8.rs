impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let mut result = 0;
        let mut count = 0;
        let mut start = 0;
        let mut end = 0;
        let mut k = k;
        let mut max = 0;
        let mut min = 0;
        for c in answer_key.chars() {
            if c == 'T' {
                count += 1;
            }
            if count > max {
                max = count;
            }
            if count < min {
                min = count;
            }
            if count - min > k {
                if answer_key.chars().nth(start).unwrap() == 'T' {
                    count -= 1;
                }
                start += 1;
                k += 1;
            }
            if max - count > k {
                if answer_key.chars().nth(start).unwrap() == 'F' {
                    count += 1;
                }
                start += 1;
                k += 1;
            }
            end += 1;
            result = std::cmp::max(result, end - start);
        }
        result as i32
    }
}