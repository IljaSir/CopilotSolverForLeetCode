impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut nums = nums;
        let mut odd = vec![];
        let mut even = vec![];
        for i in 0..n {
            if i % 2 == 0 {
                even.push(nums[i]);
            } else {
                odd.push(nums[i]);
            }
        }
        even.sort();
        odd.sort();
        odd.reverse();
        let mut res = vec![];
        for i in 0..n {
            if i % 2 == 0 {
                res.push(even[i / 2]);
            } else {
                res.push(odd[i / 2]);
            }
        }
        res
    }
}