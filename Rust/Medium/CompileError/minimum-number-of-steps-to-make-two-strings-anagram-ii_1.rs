impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut cnt = [0; 26];
        for c in s.chars() {
            cnt[c as usize - 'a' as usize] += 1;
        }
        for c in t.chars() {
            cnt[c as usize - 'a' as usize] -= 1;
        }
        cnt.iter().map(|&x| x.abs()).sum::<i32>() / 2
    }
}