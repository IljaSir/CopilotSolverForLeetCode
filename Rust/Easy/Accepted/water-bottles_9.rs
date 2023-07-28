impl Solution {
    pub fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
        
        let mut n = num_bottles;
        let mut ans = num_bottles;
        while n >= num_exchange {
            let (a, b) = (n / num_exchange, n % num_exchange);
            ans += a;
            n = a + b;
        }
        ans
    }
}