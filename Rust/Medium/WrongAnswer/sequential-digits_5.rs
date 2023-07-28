impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut i = 1;
        let mut j = 1;
        let mut n = 0;
        while i <= 9 {
            n = n * 10 + i;
            if n >= low && n <= high {
                result.push(n);
            }
            i += 1;
            if i > 9 - j {
                j += 1;
                i = j;
                n = 0;
            }
        }
        result.sort();
        result
    }
}