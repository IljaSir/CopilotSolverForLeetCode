impl Solution {
    pub fn minimum_perimeter(needed_apples: i64) -> i64 {
        
        let mut n = 1;
        let mut apples = 0;
        loop {
            let cur = 2 * (n * n + n) * (n + 1);
            apples += cur;
            if apples >= needed_apples {
                return 8 * n;
            }
            n += 1;
        }
    }
}