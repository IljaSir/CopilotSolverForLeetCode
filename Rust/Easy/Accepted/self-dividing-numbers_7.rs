impl Solution {
    pub fn self_dividing_numbers(left: i32, right: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        for num in left..right + 1 {
            let mut n = num;
            let mut ok = true;
            while n > 0 {
                let d = n % 10;
                if d == 0 || num % d != 0 {
                    ok = false;
                    break;
                }
                n /= 10;
            }
            if ok {
                result.push(num);
            }
        }
        result
    }
}