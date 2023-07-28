impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut ans = 0;
        for i in 1..=n {
            let mut s = std::collections::HashSet::new();
            let mut j = i;
            while j > 0 {
                let d = j % 10;
                if s.contains(&d) {
                    break;
                }
                s.insert(d);
                j /= 10;
            }
            if j == 0 {
                ans += 1;
            }
        }
        ans
    }
}