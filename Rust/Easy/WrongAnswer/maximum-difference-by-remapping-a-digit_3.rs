impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let mut max = 0;
        let mut min = 10;
        let mut n = num;
        while n > 0 {
            let d = n % 10;
            max = max.max(d);
            min = min.min(d);
            n /= 10;
        }
        max * 1111 + min * 111
    }
}