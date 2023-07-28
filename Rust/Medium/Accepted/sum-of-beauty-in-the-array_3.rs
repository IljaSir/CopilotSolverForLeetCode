impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut lmax = vec![0; n];
        let mut rmin = vec![0; n];
        let mut sum = 0;
        lmax[0] = nums[0];
        rmin[n - 1] = nums[n - 1];
        for i in 1..n {
            lmax[i] = lmax[i - 1].max(nums[i]);
        }
        for i in (0..n - 1).rev() {
            rmin[i] = rmin[i + 1].min(nums[i]);
        }
        for i in 1..n - 1 {
            if nums[i] > lmax[i - 1] && nums[i] < rmin[i + 1] {
                sum += 2;
            } else if nums[i] > nums[i - 1] && nums[i] < nums[i + 1] {
                sum += 1;
            }
        }
        sum
    }
}