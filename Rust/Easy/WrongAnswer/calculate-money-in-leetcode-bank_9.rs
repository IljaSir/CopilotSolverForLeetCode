impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut sum = 0;
        let mut i = 1;
        let mut j = 1;
        let mut k = 0;
        while i <= n {
            if k == 0 {
                j = i / 7;
                k = i % 7;
            }
            sum += j + k;
            i += 1;
            k += 1;
        }
        sum
    }
}