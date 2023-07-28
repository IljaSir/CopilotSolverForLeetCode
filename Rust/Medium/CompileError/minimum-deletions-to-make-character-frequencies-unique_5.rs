impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut freq = [0; 26];
        for c in s.chars() {
            freq[(c as u8 - b'a') as usize] += 1;
        }
        let mut freq = freq.iter().filter(|&x| *x > 0).collect::<Vec<_>>();
        freq.sort_unstable_by(|&a, &b| b.cmp(a));
        let mut res = 0;
        let mut prev = 0;
        for &f in freq.iter() {
            if f <= prev {
                res += prev - f + 1;
                prev = prev.max(f) - 1;
            } else {
                prev = f;
            }
        }
        res
    }
}