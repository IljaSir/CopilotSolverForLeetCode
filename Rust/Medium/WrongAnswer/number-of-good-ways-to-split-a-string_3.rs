impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut left: Vec<i32> = vec![0; 26];
        let mut right: Vec<i32> = vec![0; 26];
        let mut count = 0;
        for c in s.chars() {
            right[c as usize - 'a' as usize] += 1;
            if right[c as usize - 'a' as usize] == 1 {
                count += 1;
            }
        }
        let mut res = 0;
        for c in s.chars() {
            left[c as usize - 'a' as usize] += 1;
            if left[c as usize - 'a' as usize] == right[c as usize - 'a' as usize] {
                count -= 1;
            }
            if left[c as usize - 'a' as usize] == right[c as usize - 'a' as usize] + 1 {
                count += 1;
            }
            if count == 0 {
                res += 1;
            }
        }
        res
    }
}