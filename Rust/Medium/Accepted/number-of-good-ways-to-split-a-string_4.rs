impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut count = 0;
        let mut left = [0; 26];
        let mut right = [0; 26];
        let mut left_count = 0;
        let mut right_count = 0;
        for c in s.chars() {
            let index = c as usize - 97;
            if right[index] == 0 {
                right_count += 1;
            }
            right[index] += 1;
        }
        for c in s.chars() {
            let index = c as usize - 97;
            left[index] += 1;
            if left[index] == 1 {
                left_count += 1;
            }
            right[index] -= 1;
            if right[index] == 0 {
                right_count -= 1;
            }
            if left_count == right_count {
                count += 1;
            }
        }
        count
    }
}