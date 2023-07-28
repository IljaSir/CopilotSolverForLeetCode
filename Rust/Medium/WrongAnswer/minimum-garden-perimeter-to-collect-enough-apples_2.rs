impl Solution {
    pub fn minimum_perimeter(needed_apples: i64) -> i64 {
        
        let mut n = 1;
        while (n * n * (n + 1) * (n + 1) / 4) < needed_apples {
            n += 1;
        }
        n * 8
    }
}