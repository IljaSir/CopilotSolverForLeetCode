impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut res: Vec<i32> = Vec::new();
        for i in 1..=9 {
            let mut num = i;
            let mut j = i + 1;
            while j <= 9 {
                num = num * 10 + j;
                if num >= low && num <= high {
                    res.push(num);
                }
                j += 1;
            }
        }
        res.sort();
        res
    }
}