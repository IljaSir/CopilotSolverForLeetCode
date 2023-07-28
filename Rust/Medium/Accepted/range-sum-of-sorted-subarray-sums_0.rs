impl Solution {
    pub fn range_sum(nums: Vec<i32>, n: i32, left: i32, right: i32) -> i32 {
        
        let mut sums = Vec::new();
        for i in 0..n as usize {
            let mut sum = 0;
            for j in i..n as usize {
                sum += nums[j];
                sums.push(sum);
            }
        }
        sums.sort();
        let mut res = 0;
        for i in left-1..right {
            res = (res + sums[i as usize]) % 1000000007;
        }
        res
    }
}