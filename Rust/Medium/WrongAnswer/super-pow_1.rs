impl Solution {
    pub fn super_pow(a: i32, b: Vec<i32>) -> i32 {
        

        let mut a = a % 1337;
        let mut result = 1;
        for i in b {
            result = (result * Self::pow(a, i)) % 1337;
            a = Self::pow(a, 10);
        }
        result
    }
    
    fn pow(a: i32, b: i32) -> i32 {
        let mut a = a;
        let mut result = 1;
        for _ in 0..b {
            result = (result * a) % 1337;
        }
        result
    }
}