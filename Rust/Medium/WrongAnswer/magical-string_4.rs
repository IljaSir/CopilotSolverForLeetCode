impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        let mut s = vec![1, 2, 2];
        let mut i = 2;
        let mut j = 2;
        while s.len() < n as usize {
            let x = s[i];
            let y = 3 - s[j];
            s.push(y);
            if x == 2 {
                s.push(y);
            }
            i += 1;
            j += 1;
        }
        s[..n as usize].iter().filter(|&&x| x == 1).count() as i32
    }
}