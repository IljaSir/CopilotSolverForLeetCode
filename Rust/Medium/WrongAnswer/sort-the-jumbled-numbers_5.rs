impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for n in nums {
            let mut num = 0;
            let mut d = 1;
            let mut m = n;
            while m > 0 {
                let r = m % 10;
                m /= 10;
                num += d * mapping[r as usize];
                d *= 10;
            }
            result.push(num);
        }
        result.sort();
        result
    }
}