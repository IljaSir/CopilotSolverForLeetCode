impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut left = [0; 26];
        let mut right = [0; 26];
        for c in s.as_bytes() {
            right[(c - b'a') as usize] += 1;
        }
        let mut ans = 0;
        for c in s.as_bytes() {
            left[(c - b'a') as usize] += 1;
            right[(c - b'a') as usize] -= 1;
            if left.iter().filter(|&x| *x > 0).count() == right.iter().filter(|&x| *x > 0).count() {
                ans += 1;
            }
        }
        ans
    }
}