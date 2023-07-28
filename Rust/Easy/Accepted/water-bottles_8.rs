impl Solution {
    pub fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
        
        let mut num_bottles = num_bottles;
        let mut num_empty_bottles = 0;
        let mut total_bottles = 0;
        while num_bottles > 0 {
            num_empty_bottles += num_bottles;
            total_bottles += num_bottles;
            num_bottles = num_empty_bottles / num_exchange;
            num_empty_bottles %= num_exchange;
        }
        total_bottles
    }
}