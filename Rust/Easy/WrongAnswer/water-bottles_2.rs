impl Solution {
    pub fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
        
        let mut num_bottles = num_bottles;
        let mut num_exchange = num_exchange;
        let mut result = 0;
        while num_bottles > 0 {
            result += num_bottles;
            let mut empty_bottles = num_bottles;
            num_bottles = 0;
            while empty_bottles >= num_exchange {
                num_bottles += 1;
                empty_bottles -= num_exchange;
            }
        }
        result
    }
}