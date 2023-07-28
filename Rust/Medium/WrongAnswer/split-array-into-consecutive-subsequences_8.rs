impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut v = vec![];
        for i in 0..nums.len() {
            let mut j = 0;
            while j < v.len() && v[j] != nums[i] {
                j += 1;
            }
            if j == v.len() {
                v.push(nums[i]);
            }
        }
        let mut i = 0;
        let mut j = 0;
        while i < v.len() {
            while j < nums.len() && v[i] != nums[j] {
                j += 1;
            }
            if j == nums.len() {
                return false;
            }
            let mut k = j + 1;
            while k < nums.len() && nums[k] == nums[j] {
                k += 1;
            }
            if k - j < 3 {
                return false;
            }
            j = k;
            i += 1;
        }
        true
    }
}