impl Solution {
    pub fn sum_even_after_queries(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut sum = 0;
        let mut result = vec![];
        for num in nums.iter() {
            if num % 2 == 0 {
                sum += num;
            }
        }
        for query in queries.iter() {
            let val = query[0];
            let index = query[1] as usize;
            if nums[index] % 2 == 0 {
                sum -= nums[index];
            }
            let new_num = nums[index] + val;
            if new_num % 2 == 0 {
                sum += new_num;
            }
            result.push(sum);
        }
        result
    }
}