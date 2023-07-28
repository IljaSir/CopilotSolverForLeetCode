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
        sums[(left-1) as usize..right as usize].iter().sum::<i32>() % 1000000007
    }
}