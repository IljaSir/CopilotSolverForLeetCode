impl Solution {
    pub fn sum_even_after_queries(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut sum = nums.iter().filter(|&x| x % 2 == 0).sum::<i32>();
        for q in queries {
            let (val, index) = (q[0], q[1] as usize);
            if nums[index] % 2 == 0 {
                sum -= nums[index];
            }
            if (nums[index] + val) % 2 == 0 {
                sum += nums[index] + val;
            }
            res.push(sum);
            nums[index] += val;
        }
        res
    }
}