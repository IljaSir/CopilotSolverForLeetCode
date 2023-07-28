impl Solution {
    pub fn is_three(n: i32) -> bool {
        
        let mut cnt = 0;
        for i in 1..=n {
            if n % i == 0 {
                cnt += 1;
            }
        }
        cnt == 3
    }
}