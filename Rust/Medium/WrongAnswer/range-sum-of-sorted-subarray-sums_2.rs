impl Solution {
    pub fn range_sum(nums: Vec<i32>, n: i32, left: i32, right: i32) -> i32 {
        
        let mut sums = vec![];
        for i in 0..n {
            let mut sum = 0;
            for j in i..n {
                sum += nums[j as usize];
                sums.push(sum);
            }
        }
        sums.sort();
        let mut ans = 0;
        for i in left - 1..right {
            ans += sums[i as usize];
        }
        ans % 1_000_000_007
    }
}