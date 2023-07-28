impl Solution {
    pub fn minimum_perimeter(needed_apples: i64) -> i64 {
        
        let mut apples = 0;
        let mut i = 0;
        while apples < needed_apples {
            i += 1;
            apples += 12 * i * i;
        }
        i * 8
    }
}