impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            let mut sub = vec![];
            for j in i..nums.len() {
                sub.push(nums[j]);
                sub.sort();
                if sub[sub.len() / 2] == k {
                    count += 1;
                }
            }
        }
        count
    }
}