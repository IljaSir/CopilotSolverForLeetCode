impl Solution {
    pub fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
        
        let mut num_bottles = num_bottles;
        let mut num_empty = 0;
        let mut total = 0;
        while num_bottles > 0 {
            total += num_bottles;
            num_empty += num_bottles;
            num_bottles = num_empty / num_exchange;
            num_empty -= num_bottles * num_exchange;
        }
        total
    }
}