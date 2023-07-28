impl Solution {
    pub fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
        
        let mut result = num_bottles;
        let mut empty = num_bottles;
        while empty >= num_exchange {
            let full = empty / num_exchange;
            result += full;
            empty = full + empty % num_exchange;
        }
        result
    }
}