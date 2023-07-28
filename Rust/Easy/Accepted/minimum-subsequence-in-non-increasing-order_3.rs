impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        for n in &nums {
            sum += n;
        }
        let mut result = vec![];
        let mut sub_sum = 0;
        while sub_sum <= sum {
            let n = nums.pop().unwrap();
            result.push(n);
            sub_sum += n;
            sum -= n;
        }
        result
    }
}