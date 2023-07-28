impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut res = 0;
        let mut left = vec![0; 26];
        let mut right = vec![0; 26];
        let mut left_cnt = 0;
        let mut right_cnt = 0;
        for c in s.chars() {
            let i = (c as u8 - 'a' as u8) as usize;
            if right[i] == 0 {
                right_cnt += 1;
            }
            right[i] += 1;
        }
        for c in s.chars() {
            let i = (c as u8 - 'a' as u8) as usize;
            if left[i] == 0 {
                left_cnt += 1;
            }
            left[i] += 1;
            if right[i] == 1 {
                right_cnt -= 1;
            }
            right[i] -= 1;
            if left_cnt == right_cnt {
                res += 1;
            }
        }
        res
    }
}