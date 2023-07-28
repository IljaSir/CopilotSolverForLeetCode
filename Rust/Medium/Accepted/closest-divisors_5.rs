impl Solution {
    pub fn closest_divisors(num: i32) -> Vec<i32> {
        
        let num1 = num + 1;
        let num2 = num + 2;
        let mut result1 = Self::find_closest_divisor(num1);
        let result2 = Self::find_closest_divisor(num2);
        if (result1[0] - result1[1]).abs() > (result2[0] - result2[1]).abs() {
            result1 = result2;
        }
        result1
    }
    
    fn find_closest_divisor(num: i32) -> Vec<i32> {
        let mut result = vec![];
        let mut i = 1;
        while i * i <= num {
            if num % i == 0 {
                result.clear();
                result.push(i);
                result.push(num / i);
            }
            i += 1;
        }
        result
    }
}