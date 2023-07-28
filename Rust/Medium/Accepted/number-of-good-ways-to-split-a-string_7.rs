impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut left = vec![0; 26];
        let mut right = vec![0; 26];
        let mut result = 0;
        let mut left_count = 0;
        let mut right_count = 0;
        for c in s.as_bytes() {
            let i = *c - b'a';
            if right[i as usize] == 0 {
                right_count += 1;
            }
            right[i as usize] += 1;
        }
        for c in s.as_bytes() {
            let i = *c - b'a';
            left[i as usize] += 1;
            if left[i as usize] == 1 {
                left_count += 1;
            }
            right[i as usize] -= 1;
            if right[i as usize] == 0 {
                right_count -= 1;
            }
            if left_count == right_count {
                result += 1;
            }
        }
        result
    }
}