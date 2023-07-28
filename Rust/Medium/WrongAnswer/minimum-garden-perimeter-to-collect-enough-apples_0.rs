impl Solution {
    pub fn minimum_perimeter(needed_apples: i64) -> i64 {
        
        let mut n = 0;
        let mut sum = 0;
        while sum < needed_apples {
            n += 1;
            sum += 12 * n * (n + 1) * (2 * n + 1) / 6;
        }
        8 * n
    }
}