impl Solution {
    pub fn range_sum(nums: Vec<i32>, n: i32, left: i32, right: i32) -> i32 {
        
        let mut nums = nums;
        let mut sums = vec![];
        for i in 0..n as usize {
            let mut sum = 0;
            for j in i..n as usize {
                sum += nums[j];
                sums.push(sum);
            }
        }
        sums.sort();
        let mut sum = 0;
        for i in left as usize - 1..right as usize {
            sum += sums[i];
        }
        sum % 1_000_000_007
    }
}