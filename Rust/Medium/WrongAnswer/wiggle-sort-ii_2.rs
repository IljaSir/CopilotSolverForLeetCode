impl Solution {
    pub fn wiggle_sort(nums: &mut Vec<i32>) {
        

        nums.sort();
        let mut res = Vec::new();
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < j {
            res.push(nums[j]);
            res.push(nums[i]);
            i += 1;
            j -= 1;
        }
        if i == j {
            res.push(nums[i]);
        }
        for i in 0..nums.len() {
            nums[i] = res[i];
        }
    }
}