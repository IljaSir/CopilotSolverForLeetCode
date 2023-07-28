impl Solution {
    pub fn maximum_even_split(final_sum: i64) -> Vec<i64> {
        
        let mut res = vec![];
        let mut sum = 0;
        for i in 1..=final_sum/2 {
            sum += i;
            res.push(i);
            if sum == final_sum - sum {
                break;
            }
        }
        res
    }
}