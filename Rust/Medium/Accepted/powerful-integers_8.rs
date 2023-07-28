impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut i = 0;
        let mut j = 0;
        let mut power = 1;
        while power < bound {
            j = 0;
            let mut power2 = 1;
            while power + power2 <= bound {
                if !result.contains(&(power + power2)) {
                    result.push(power + power2);
                }
                j += 1;
                power2 = power2 * y;
                if y == 1 {
                    break;
                }
            }
            i += 1;
            power = power * x;
            if x == 1 {
                break;
            }
        }
        result
    }
}