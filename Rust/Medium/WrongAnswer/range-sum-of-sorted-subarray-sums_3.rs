impl Solution {
    pub fn range_sum(nums: Vec<i32>, n: i32, left: i32, right: i32) -> i32 {
        
        let mut sums = vec![0; n as usize];
        let mut sum = 0;
        for i in 0..n as usize {
            sum += nums[i];
            sums[i] = sum;
        }
        let mut arr = vec![0; (n * (n + 1) / 2) as usize];
        let mut index = 0;
        for i in 0..n as usize {
            for j in i..n as usize {
                arr[index] = sums[j] - sums[i] + nums[i];
                index += 1;
            }
        }
        arr.sort();
        let mut sum = 0;
        for i in left as usize - 1..right as usize {
            sum += arr[i];
        }
        sum
    }
}