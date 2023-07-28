impl Solution {
    pub fn count_palindromic_subsequence(s: String) -> i32 {
        
        let mut res = 0;
        let mut left = [0; 26];
        let mut right = [0; 26];
        let mut count = [0; 26];
        let mut i = 0;
        for c in s.chars() {
            if left[c as usize - 'a' as usize] == 0 {
                left[c as usize - 'a' as usize] = i + 1;
            }
            right[c as usize - 'a' as usize] = i + 1;
            count[c as usize - 'a' as usize] += 1;
            i += 1;
        }
        for i in 0..26 {
            if count[i] > 1 {
                res += right[i] - left[i];
            }
        }
        res
    }
}