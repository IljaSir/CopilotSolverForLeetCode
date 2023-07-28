impl Solution {
    pub fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
        
        let mut num_bottles = num_bottles;
        let mut num_exchange = num_exchange;
        let mut result = num_bottles;
        while num_bottles >= num_exchange {
            let exchange = num_bottles / num_exchange;
            let remainder = num_bottles % num_exchange;
            result += exchange;
            num_bottles = exchange + remainder;
        }
        result
    }
}