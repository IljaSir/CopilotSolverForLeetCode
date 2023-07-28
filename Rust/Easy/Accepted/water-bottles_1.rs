impl Solution {
    pub fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
        
        let mut bottles = num_bottles;
        let mut empty_bottles = num_bottles;
        while empty_bottles >= num_exchange {
            let new_bottles = empty_bottles / num_exchange;
            bottles += new_bottles;
            empty_bottles = empty_bottles % num_exchange + new_bottles;
        }
        bottles
    }
}