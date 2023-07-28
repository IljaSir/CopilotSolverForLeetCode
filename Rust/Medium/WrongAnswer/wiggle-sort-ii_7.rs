impl Solution {
    pub fn wiggle_sort(nums: &mut Vec<i32>) {
        

        let n = nums.len();
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = n - 1;
        let mut res = vec![0; n];
        let mut k = 0;
        while i < j {
            res[k] = nums[i];
            res[k + 1] = nums[j];
            i += 1;
            j -= 1;
            k += 2;
        }
        if n % 2 == 1 {
            res[n - 1] = nums[i];
        }
        for i in 0..n {
            nums[i] = res[i];
        }
    }
}