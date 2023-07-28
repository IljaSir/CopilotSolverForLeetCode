impl Solution {
    pub fn reach_number(target: i32) -> i32 {
        
        let target = target.abs() as i64;
        let mut k = 0;
        let mut sum = 0;
        while sum < target {
            k += 1;
            sum += k;
        }
        while (sum - target) % 2 != 0 {
            k += 1;
            sum += k;
        }
        k
    }
}