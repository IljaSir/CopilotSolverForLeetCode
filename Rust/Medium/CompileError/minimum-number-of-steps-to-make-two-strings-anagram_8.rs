impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut count = vec![0; 26];
        for c in s.chars() {
            count[(c as u8 - 'a' as u8) as usize] += 1;
        }
        for c in t.chars() {
            count[(c as u8 - 'a' as u8) as usize] -= 1;
        }
        count.iter().map(|&x| x.abs()).sum::<i32>() / 2
    }
}