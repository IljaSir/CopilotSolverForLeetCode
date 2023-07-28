impl Solution {
    pub fn maximum_even_split(final_sum: i64) -> Vec<i64> {
        
        let mut ans = Vec::new();
        let mut sum = 0;
        let mut i = 1;
        while sum < final_sum {
            ans.push(i);
            sum += i;
            i += 2;
        }
        while sum > final_sum {
            ans.pop();
            sum -= i - 2;
            i -= 2;
        }
        ans
    }
}