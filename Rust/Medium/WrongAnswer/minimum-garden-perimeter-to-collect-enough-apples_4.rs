impl Solution {
    pub fn minimum_perimeter(needed_apples: i64) -> i64 {
        
        let mut n = 1;
        let mut apples = 0;
        while apples < needed_apples {
            n += 2;
            apples += 4 * (n - 1) * (n - 1);
        }
        n * 4
    }
}