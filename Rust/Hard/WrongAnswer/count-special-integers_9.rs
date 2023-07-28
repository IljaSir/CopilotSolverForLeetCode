impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut i = 1;
        let mut j = 10;
        let mut count = 0;
        while i <= n {
            count += 9 * i / j;
            i *= 10;
            j *= 10;
        }
        count
    }
}