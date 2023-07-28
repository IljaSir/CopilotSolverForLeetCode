impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut left = vec![0;26];
        let mut right = vec![0;26];
        let s = s.as_bytes();
        let n = s.len();
        for i in 0..n {
            right[(s[i] - b'a') as usize] += 1;
        }
        let mut res = 0;
        for i in 0..n-1 {
            left[(s[i] - b'a') as usize] += 1;
            right[(s[i] - b'a') as usize] -= 1;
            if left.iter().filter(|&x| *x > 0).count() == right.iter().filter(|&x| *x > 0).count() {
                res += 1;
            }
        }
        res
    }
}