impl Solution {
    pub fn wiggle_sort(nums: &mut Vec<i32>) {
        

        nums.sort();
        let n = nums.len();
        let mut tmp = Vec::new();
        for i in 0..n/2 {
            tmp.push(nums[i]);
            tmp.push(nums[n/2+i]);
        }
        if n%2 == 1 {
            tmp.push(nums[n-1]);
        }
        for i in 0..n {
            nums[i] = tmp[i];
        }
    }
}