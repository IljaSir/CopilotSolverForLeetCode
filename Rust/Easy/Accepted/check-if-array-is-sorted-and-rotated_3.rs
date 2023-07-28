impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut sorted = nums.clone();
        sorted.sort();
        for i in 0..nums.len() {
            if sorted == nums.iter().cycle().skip(i).take(nums.len()).map(|x| *x).collect::<Vec<i32>>() {
                return true;
            }
        }
        false
    }
}