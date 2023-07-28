impl Solution {
    pub fn sum_even_after_queries(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut sum = 0;
        let mut res = Vec::new();
        for num in nums.iter() {
            if num % 2 == 0 {
                sum += num;
            }
        }
        for query in queries.iter() {
            let (val, index) = (query[0], query[1] as usize);
            if nums[index] % 2 == 0 {
                sum -= nums[index];
            }
            if (nums[index] + val) % 2 == 0 {
                sum += nums[index] + val;
            }
            res.push(sum);
        }
        res
    }
}