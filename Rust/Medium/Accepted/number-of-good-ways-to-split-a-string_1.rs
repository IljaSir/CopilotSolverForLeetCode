impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut left = vec![0; 26];
        let mut right = vec![0; 26];
        let mut left_count = 0;
        let mut right_count = 0;
        let mut result = 0;
        for c in s.chars() {
            let idx = c as usize - 'a' as usize;
            if right[idx] == 0 {
                right_count += 1;
            }
            right[idx] += 1;
        }
        for c in s.chars() {
            let idx = c as usize - 'a' as usize;
            if left[idx] == 0 {
                left_count += 1;
            }
            left[idx] += 1;
            right[idx] -= 1;
            if right[idx] == 0 {
                right_count -= 1;
            }
            if left_count == right_count {
                result += 1;
            }
        }
        result
    }
}