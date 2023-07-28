impl Solution {
    pub fn count_palindromic_subsequence(s: String) -> i32 {
        
        let mut result = 0;
        let mut start = 0;
        let mut end = s.len() - 1;
        let mut left = [0; 26];
        let mut right = [0; 26];
        let mut mid = [0; 26];
        let mut s = s.as_bytes();
        while start <= end {
            left[(s[start] - b'a') as usize] += 1;
            right[(s[end] - b'a') as usize] += 1;
            start += 1;
            end -= 1;
        }
        start = 0;
        end = s.len() - 1;
        while start <= end {
            if start == end {
                mid[(s[start] - b'a') as usize] += 1;
            } else {
                mid[(s[start] - b'a') as usize] += 1;
                mid[(s[end] - b'a') as usize] += 1;
            }
            start += 1;
            end -= 1;
        }
        for i in 0..26 {
            if left[i] > 0 && right[i] > 0 {
                result += mid[i] - 2;
            }
        }
        result
    }
}