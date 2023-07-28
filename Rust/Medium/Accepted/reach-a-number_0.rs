impl Solution {
    pub fn reach_number(target: i32) -> i32 {
        
        let target = target.abs();
        let mut k = 0;
        while k * (k + 1) / 2 < target {
            k += 1;
        }
        if k * (k + 1) / 2 == target {
            return k;
        }
        let mut diff = k * (k + 1) / 2 - target;
        if diff % 2 == 0 {
            return k;
        }
        if k % 2 == 0 {
            return k + 1;
        }
        k + 2
    }
}