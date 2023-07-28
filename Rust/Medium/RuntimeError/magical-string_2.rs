impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        let mut s = vec![1, 2, 2];
        let mut i = 2;
        while s.len() < n as usize {
            s.extend(vec![s[i] ^ 3; s[i + 1] as usize]);
            i += 2;
        }
        s[0..n as usize].iter().filter(|&&x| x == 1).count() as i32
    }
}