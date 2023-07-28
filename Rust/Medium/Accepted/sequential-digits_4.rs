impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut result = vec![];
        for i in 1..=9 {
            let mut j = i;
            let mut num = j;
            while j < 10 && num <= high {
                if num >= low {
                    result.push(num);
                }
                j += 1;
                num = num * 10 + j;
            }
        }
        result.sort();
        result
    }
}