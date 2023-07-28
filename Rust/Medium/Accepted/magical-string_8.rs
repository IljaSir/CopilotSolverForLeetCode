impl Solution {
    pub fn magical_string(n: i32) -> i32 {
        

        let mut s: Vec<i32> = vec![1,2,2];
        let mut i = 2;
        while s.len() < n as usize {
            let n = s[i];
            let v = if s[s.len()-1] == 1 { 2 } else { 1 };
            for _ in 0..n {
                s.push(v);
            }
            i += 1;
        }
        s[0..n as usize].iter().filter(|&&c| c == 1).count() as i32
    }
}