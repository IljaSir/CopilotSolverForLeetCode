impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let mut v = vec![true; n as usize + 1];
        let mut count = 0;
        Self::backtrack(n, 1, &mut v, &mut count);
        count
    }
    fn backtrack(n: i32, pos: i32, v: &mut Vec<bool>, count: &mut i32) {
        if pos > n {
            *count += 1;
            return;
        }
        for i in 1..=n {
            if v[i as usize] && (pos % i == 0 || i % pos == 0) {
                v[i as usize] = false;
                Self::backtrack(n, pos + 1, v, count);
                v[i as usize] = true;
            }
        }