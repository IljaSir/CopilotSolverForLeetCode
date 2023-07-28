impl Solution {
    pub fn pivot_integer(n: i32) -> i32 {
        
        let mut i = 1;
        let mut sum = 0;
        while i <= n {
            sum += i;
            i += 1;
        }
        let mut j = n;
        let mut sum2 = 0;
        while j >= 1 {
            sum2 += j;
            j -= 1;
            if sum == sum2 {
                return j;
            }
        }
        return -1;
    }
}