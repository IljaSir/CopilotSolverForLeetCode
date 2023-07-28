impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut count = vec![0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        for c in t.chars() {
            count[c as usize - 'a' as usize] -= 1;
        }
        count.iter().filter(|&&x| x > 0).sum::<i32>()
    }
}