impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut a: [i32; 26] = [0; 26];
        for c in s.chars() {
            a[(c as u8 - b'a') as usize] += 1;
        }
        let mut b: Vec<i32> = a.iter().filter(|&x| *x > 0).copied().collect();
        b.sort_by(|x, y| y.cmp(x));
        let mut res = 0;
        for i in 1..b.len() {
            if b[i] == b[i - 1] {
                b[i] -= 1;
                res += 1;
                if b[i] == 0 {
                    b.remove(i);
                }
            }
        }
        res
    }
}