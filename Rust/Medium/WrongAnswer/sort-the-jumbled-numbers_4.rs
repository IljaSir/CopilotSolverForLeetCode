impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        for num in nums {
            let mut n = 0;
            let mut base = 1;
            let mut i = num;
            while i > 0 {
                let digit = i % 10;
                n += mapping[digit as usize] * base;
                base *= 10;
                i /= 10;
            }
            result.push(n);
        }
        result.sort();
        result
    }
}