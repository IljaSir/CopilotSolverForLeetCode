impl Solution {
    pub fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
        
        let mut count = num_bottles;
        let mut empty = num_bottles;
        while empty >= num_exchange {
            let full = empty / num_exchange;
            empty = empty % num_exchange + full;
            count += full;
        }
        count
    }
}