impl Solution {
    pub fn minimum_difference(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut nums = nums;
        nums.sort();
        nums.windows(k).map(|w| w.last().unwrap() - w.first().unwrap()).min().unwrap()
    }
}