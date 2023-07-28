impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut total = 0;
        let mut i = 1;
        let mut j = 1;
        let mut k = 0;
        while k < n {
            total += i;
            i += 1;
            k += 1;
            if j == 7 {
                j = 0;
                i -= 6;
            }
            j += 1;
        }
        total
    }
}