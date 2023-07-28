impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut low = low;
        let mut high = high;
        let mut result = Vec::new();
        while low < high {
            let mut num = low;
            let mut last_digit = num % 10;
            let mut ok = true;
            while num > 0 {
                let digit = num % 10;
                if digit != last_digit {
                    ok = false;
                    break;
                }
                last_digit = (digit + 1) % 10;
                num /= 10;
            }
            if ok {
                result.push(low);
            }
            low += 1;
        }
        result
    }
}