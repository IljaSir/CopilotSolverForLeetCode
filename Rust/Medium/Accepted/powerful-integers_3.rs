impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        let mut x_power = 1;
        while x_power < bound {
            let mut y_power = 1;
            while y_power < bound {
                let sum = x_power + y_power;
                if sum <= bound && !result.contains(&sum) {
                    result.push(sum);
                }
                if y == 1 {
                    break;
                }
                y_power *= y;
            }
            if x == 1 {
                break;
            }
            x_power *= x;
        }
        result
    }
}