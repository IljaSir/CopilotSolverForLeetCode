impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut  usiz.charse - 'a' as usize] += 1;
        }
        for c in t.chars() {
            count[c as usize - 'a' as usize] -= 1;
        }
        count.iter().map(|&x| x.abs()).sum::<i32>() / 2
    }
}