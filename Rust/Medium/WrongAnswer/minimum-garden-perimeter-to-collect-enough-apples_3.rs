impl Solution {
    pub fn minimum_perimeter(needed_apples: i64) -> i64 {
        
        let mut k = 1;
        let mut apples = 0;
        while apples < needed_apples {
            k += 1;
            apples += 12 * k * (k + 1) * (2 * k + 1) / 6;
        }
        k * 8
    }
}