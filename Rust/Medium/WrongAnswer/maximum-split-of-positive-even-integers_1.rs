impl Solution {
    pub fn maximum_even_split(final_sum: i64) -> Vec<i64> {
        
        let mut res = vec![];
        let mut sum = 0;
        for i in 1..=final_sum/2 {
            sum += i*2;
            res.push(i*2);
            if sum == final_sum {
                return res;
            } else if sum > final_sum {
                res.pop();
                sum -= i*2;
            }
        }
        res
    }
}