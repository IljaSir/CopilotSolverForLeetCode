impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut arr = [0; 26];
        for c in s.chars() {
            arr[c as usize - 'a' as usize] += 1;
        }
        for c in t.chars() {
            arr[c as usize - 'a' as usize] -= 1;
        }
        arr.iter().map(|&x| x.abs()).sum::<i32>() / 2
    }
}