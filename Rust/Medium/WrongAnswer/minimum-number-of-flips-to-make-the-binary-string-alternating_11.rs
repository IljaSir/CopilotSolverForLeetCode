impl Solution {
    pub fn min_flips(s: String) -> i32 {
        
        let s = s.chars().collect::<Vec<_>>();
        let n = s.len();
        let mut ans = n;
        for i in 0..n {
            let mut cnt = 0;
            for j in 0..n {
                if s[(i + j) % n] != "10".chars().nth(j % 2).unwrap() {
                    cnt += 1;
                }
            }
            ans = ans.min(cnt);
        }
        ans as i32
    }
}