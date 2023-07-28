impl Solution {
    pub fn maximum_even_split(final_sum: i64) -> Vec<i64> {
        
        let mut result = Vec::new();
        let mut sum = 0;
        let mut num = 2;
        while sum < final_sum {
            result.push(num);
            sum += num;
            num += 2;
        }
        result
    }
}