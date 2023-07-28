impl Solution {
    pub fn wiggle_sort(nums: &mut Vec<i32>) {
        

        nums.sort();
        let n = nums.len();
        let mut res = vec![0;n];
        let mut i = 0;
        let mut j = 1;
        let mut k = 0;
        while i < n {
            res[j] = nums[i];
            i += 1;
            j += 2;
        }
        while j < n {
            res[k] = nums[i];
            i += 1;
            k += 2;
        }
        nums.copy_from_slice(&res);
    }
}